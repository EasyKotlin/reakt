package com.easykotlin.reakt.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Kor on 2017-12-24 14:04:07.
 */
@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping(value = ["/currentUser.json"])
    fun currentUser(): UserDto {
        val UserDto = UserDto()
        try {
            UserDto.success = true
            val loginUser = UserController.UserDto.LoginUser()
            val UserDetails = SecurityContextHolder
                .getContext()
                .authentication
                .principal
                    as UserDetails
            loginUser.username = UserDetails.username
            UserDto.loginUser = loginUser
        } catch (e: Exception) {
            UserDto.success = false
            UserDto.loginUser = UserController.UserDto.LoginUser()
            e.printStackTrace()
        }
        return UserDto
    }

    class UserDto {
        var success = false
        lateinit var loginUser: LoginUser

        class LoginUser {
            var username = "NULL"
        }
    }

}
