
package com.easykotlin.reakt.dao

import com.easykotlin.reakt.entity.Article
import org.springframework.data.jpa.repository.JpaRepository


/**
 * Created by Kor on 2017-12-23 21:31:24.
 */
interface ArticleDao : JpaRepository<Article, Long> {

}
