package com.easykotlin.reakt.controller

import com.alibaba.fastjson.JSON
import com.easykotlin.reakt.dao.CategoryDao
import com.easykotlin.reakt.entity.Category
import com.easykotlin.reakt.page.PageConterter
import com.easykotlin.reakt.page.PageDto
import org.springframework.beans.factory.annotation.Autowired
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


    @GetMapping(value = ["/page.json"])
    fun page(
        @RequestParam(value = "currentPage", defaultValue = "1") currentPage: Int,
        @RequestParam(value = "pageSize", defaultValue = "10") pageSize: Int,
        @RequestParam(value = "searchTxt", defaultValue = "") searchTxt: String,
        @RequestParam(value = "type", defaultValue = "1") type: Int
    ): PageDto<Category> {

        println("searchTxt = $searchTxt")

        // Spring Data JPA 的分页默认第一页是： pageNum = 0
        val page = CategoryDao.page(searchTxt, type,
                PageRequest.of(currentPage - 1, pageSize))
        println("page = ${JSON.toJSONString(page)}")
        val pageDto = PageDto<Category>()
        PageConterter.convert(page, pageDto)
        return pageDto
    }

}
