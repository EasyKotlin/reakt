package com.easykotlin.reakt.service

import com.easykotlin.reakt.dao.UserDao
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailService : UserDetailsService {
    val logger = LoggerFactory.getLogger(MyUserDetailService::class.java)

    @Autowired lateinit var userDao: UserDao


    override fun loadUserByUsername(username: String): UserDetails {
        val user = userDao.findByUsername(username) ?: throw  UsernameNotFoundException(username + " not found")

        logger.info("user = {}", user)
        val roles = user.roles
        val authorities = mutableSetOf<SimpleGrantedAuthority>()
        roles.forEach {
            authorities.add(SimpleGrantedAuthority(it.role))
        }
        return org.springframework.security.core.userdetails.User( // 此处为了区分我们本地系统中的 User 实体类，特意列出userdetails 的 User 类的全路径
                username,
                user.password,
                authorities
        )
    }
}
