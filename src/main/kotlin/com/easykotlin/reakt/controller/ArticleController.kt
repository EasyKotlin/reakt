
package com.easykotlin.reakt.controller

import com.easykotlin.reakt.dao.ArticleDao
import com.easykotlin.reakt.entity.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest

/**
 * Created by Kor on 2017-12-23 21:31:24.
 */
@RestController
@RequestMapping("/article")
class ArticleController {

    @Autowired lateinit var ArticleDao: ArticleDao

    @GetMapping(value = ["/"])
    fun article(request: HttpServletRequest): List<Article>{
        return ArticleDao.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id:Long): Article {
        return ArticleDao.getOne(id)
    }
}
