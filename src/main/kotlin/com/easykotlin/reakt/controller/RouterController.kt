package com.easykotlin.reakt.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RouterController {


    @GetMapping(value = ["", "/", "/index"])
    fun index(): String {
        return "/index"
    }


    @GetMapping(value = ["/article_list"])
    fun articleList(): String {
        return "/article_list"
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = ["/admin"])
    fun admin(): String {
        return "/admin"
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping(value = ["/user"])
    fun user(): String {
        return "/user"
    }

}
