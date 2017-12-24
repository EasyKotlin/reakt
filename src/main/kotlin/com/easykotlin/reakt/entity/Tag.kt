
package com.easykotlin.reakt.entity

import javax.persistence.*
import java.util.Date


/**
 * Created by Kor on 2017-12-24 14:04:07.
 */
@Entity
class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    var gmtCreate = Date()
    var gmtModify = Date()
    var isDeleted = 0
}
