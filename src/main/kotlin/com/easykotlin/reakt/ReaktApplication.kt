package com.easykotlin.reakt

import com.easykotlin.reakt.dao.RoleDao
import com.easykotlin.reakt.dao.UserDao
import com.easykotlin.reakt.entity.Role
import com.easykotlin.reakt.entity.User
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
// exclude, 有异常不会找默认error页面了，而是直接输出字符串
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration::class])
class ReaktApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        try {
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
                }
            }
    ).sources(ReaktApplication::class.java).run(*args)
}
