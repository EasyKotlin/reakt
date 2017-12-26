package com.easykotlin.reakt.page

import org.springframework.data.domain.Page


class PageDto<T> {
    var content: Content<T> = Content()
}

class Content<T> {
    var data: List<T> = ArrayList()
    var currentPage = 1
    var totalCount = 100L
}

object PageConterter {
    fun <T> convert(page: Page<T>, pageDto: PageDto<T>) {
        pageDto.content.data = page.content
        // Spring Data JPA 的分页默认第一页是： pageNum = 0, 所以这里 + 1
        pageDto.content.currentPage = page.number + 1
        pageDto.content.totalCount = page.totalElements
    }
}
