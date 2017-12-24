package com.easykotlin.reakt.entity

import java.util.*
import javax.persistence.*


/**
 * Created by Kor on 2017-12-24 14:04:20.
 */
@Entity
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    var gmtCreate = Date()
    var gmtModify = Date()
    var isDeleted = 0

    @Column(unique = true, length = 200)
    var name = ""
    @Column(length = 200)
    var detail = ""

    /**
     * 1 学科分类
     * 2 图书分类
     * 3 行业分类
     * 4 动植物分类
     * 5 国家分类
     * 6 语言分类
     * 7 宗教分类
     * 8 组织机构分类
     * 9 音乐分类
     * 10 文学分类
     * 11 计算机编程语言分类
     *
     */
    var type = 1
    // 编码
    @Column(unique = true, length = 200)
    var code = "001"

}
