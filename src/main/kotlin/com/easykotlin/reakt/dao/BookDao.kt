
package com.easykotlin.reakt.dao

import com.easykotlin.reakt.entity.Book
import org.springframework.data.jpa.repository.JpaRepository


/**
 * Created by Kor on 2017-12-23 21:30:26.
 */
interface BookDao : JpaRepository<Book, Long> {

}
