
package com.easykotlin.reakt.dao

import com.easykotlin.reakt.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository


/**
 * Created by Kor on 2017-12-24 14:04:07.
 */
interface TagDao : JpaRepository<Tag, Long> {

}
