package com.easykotlin.reakt.entity

import javax.persistence.*


/**
 * Created by jack on 2017/4/29.
 */
@Entity
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @Column(length = 50, unique = true)
    var role: String = "ROLE_USER"
}
