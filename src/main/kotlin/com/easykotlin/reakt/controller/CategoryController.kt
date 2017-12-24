package com.easykotlin.reakt.controller

import com.easykotlin.reakt.dao.CategoryDao
import com.easykotlin.reakt.entity.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

/**
 * Created by Kor on 2017-12-24 14:04:20.
 */
@RestController
@RequestMapping("/category")
class CategoryController {

    @Autowired lateinit var CategoryDao: CategoryDao

    @GetMapping(value = ["/"])
    fun category(request: HttpServletRequest): List<Category> {
        return CategoryDao.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id: Long): Category {
        return CategoryDao.getOne(id)
    }


    @GetMapping(value = ["/page"])
    fun page(
        @RequestParam(value = "pageNum", defaultValue = "0") pageNum: Int,
        @RequestParam(value = "pageSize", defaultValue = "10") pageSize: Int,
        @RequestParam(value = "searchText", defaultValue = "") searchText: String
    ): Page<Category> {

        return CategoryDao.page(searchText, PageRequest.of(pageNum, pageSize))

    }

}
