
package com.easykotlin.reakt.controller

import com.easykotlin.reakt.dao.BookDao
import com.easykotlin.reakt.entity.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest

/**
 * Created by Kor on 2017-12-23 21:30:26.
 */
@RestController
@RequestMapping("/book")
class BookController {

    @Autowired lateinit var BookDao: BookDao

    @GetMapping(value = ["/"])
    fun book(request: HttpServletRequest): List<Book>{
        return BookDao.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id:Long): Book {
        return BookDao.getOne(id)
    }
}
