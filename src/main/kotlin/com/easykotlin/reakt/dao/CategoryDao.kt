package com.easykotlin.reakt.dao

import com.easykotlin.reakt.entity.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


/**
 * Created by Kor on 2017-12-24 14:04:20.
 */
interface CategoryDao : JpaRepository<Category, Long> {


    /**
     * Paging query needs to have a Pageable parameter!
     */
    @Query("select a from #{#entityName} a where a.name like %:searchText%")
    fun page(@Param("searchText") searchText: String, pageable: Pageable): Page<Category>

}
