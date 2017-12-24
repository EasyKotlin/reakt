
package com.easykotlin.reakt.controller

import com.easykotlin.reakt.dao.TagDao
import com.easykotlin.reakt.entity.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest

/**
 * Created by Kor on 2017-12-24 14:04:07.
 */
@RestController
@RequestMapping("/tag")
class TagController {

    @Autowired lateinit var TagDao: TagDao

    @GetMapping(value = ["/"])
    fun tag(request: HttpServletRequest): List<Tag>{
        return TagDao.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id:Long): Tag {
        return TagDao.getOne(id)
    }
}
