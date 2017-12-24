package com.easykotlin.reakt.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RouterController {

    @GetMapping(value = ["", "/", "/index"])
    fun index(): String {
        return "/index"
    }

    @GetMapping(value = ["/article_list"])
    fun article_list(): String {
        return "/article_list"
    }

    @GetMapping(value = ["/category_list"])
    fun category_list(): String {
        return "/category_list"
    }

    @GetMapping(value = ["/tag_list"])
    fun tag_list(): String {
        return "/tag_list"
    }

}
