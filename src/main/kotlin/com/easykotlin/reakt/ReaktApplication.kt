package com.easykotlin.reakt

import com.easykotlin.reakt.dao.CategoryDao
import com.easykotlin.reakt.dao.RoleDao
import com.easykotlin.reakt.dao.UserDao
import com.easykotlin.reakt.entity.Category
import com.easykotlin.reakt.entity.Role
import com.easykotlin.reakt.entity.User
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.io.File

@SpringBootApplication
// exclude, 有异常不会找默认error页面了，而是直接输出字符串
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration::class])
class ReaktApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        initUsers()
                        initCategory()
                    }
                }
            }
    ).sources(ReaktApplication::class.java).run(*args)
}

private fun BeanDefinitionDsl.BeanDefinitionContext.initCategory() {
    /** 初始化学科分类数据 */

    val CategoryDao = ref<CategoryDao>()
    println(File(".").absolutePath) // /Users/jack/easykotlin/reakt/.
    val f1 = File("src/main/resources/学科分类.data")
    f1.readLines().forEach {
        try {
            val items = it.split("=")
            println("${items[0]}=${items[1]}")
            val category = Category()
            category.code = items[0]
            category.name = items[1]
            category.detail = items[2]
            category.type = 1
            CategoryDao.save(category)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /** 初始化图书分类数据 */

    println(File(".").absolutePath) // /Users/jack/easykotlin/reakt/.
    val f2 = File("src/main/resources/图书分类.data")
    f2.readLines().forEach {
        try {
            val items = it.split("=")
            println("${items[0]}=${items[1]}")
            val category = Category()
            category.code = items[0]
            category.name = items[1]
            category.type = 2
            CategoryDao.save(category)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /** 初始化全球行业分类数据 */

    println(File(".").absolutePath) // /Users/jack/easykotlin/reakt/.
    val f3 = File("src/main/resources/全球行业分类.data")
    f3.readLines().forEach {
        try {
            val items = it.split("=")
            println("${items[0]}=${items[1]}")
            val category = Category()
            category.code = items[0]
            category.name = items[1]
            category.type = 3
            CategoryDao.save(category)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private fun BeanDefinitionDsl.BeanDefinitionContext.initUsers() {
    try {
        /** 初始化管理员用户 */
        val roleDao = ref<RoleDao>()
        // 普通用户角色
        val roleUser = Role()
        roleUser.role = "ROLE_USER"
        val r1 = roleDao.save(roleUser)

        // 超级管理员角色
        val roleAdmin = Role()
        roleAdmin.role = "ROLE_ADMIN"
        val r2 = roleDao.save(roleAdmin)

        val userDao = ref<UserDao>()
        // 普通用户
        val user = User()
        user.username = "user"
        user.password = BCryptPasswordEncoder().encode("user")
        val userRoles = setOf(r1)
        user.roles = userRoles
        userDao.save(user)

        // 超级管理员用户
        val admin = User()
        admin.username = "admin"
        admin.password = BCryptPasswordEncoder().encode("admin")
        val adminRoles = setOf(r1, r2)
        admin.roles = adminRoles
        userDao.save(admin)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
