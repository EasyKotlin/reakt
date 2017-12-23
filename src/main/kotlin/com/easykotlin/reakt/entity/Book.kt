
package com.easykotlin.reakt.entity

import javax.persistence.*
import java.util.Date


/**
 * Created by Kor on 2017-12-23 21:30:26.
 */
@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    var gmtCreate = Date()
    var gmtModify = Date()
    var isDeleted = 0
}
