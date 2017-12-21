package com.easykotlin.reakt

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyTest {

    @Test
    fun test(){
        println(sql)
    }

    val sql = "<script> SELECT\n" +
            "a.id id,\n" +
            "a.gmt_create gmtCreate,\n" +
            "a.gmt_modified gmtModified,\n" +
            "a.app_id appId,\n" +
            "a.app_name appName,\n" +
            "a.dept_no deptNo,\n" +
            "a.dept_name deptName,\n" +
            "a.aone_product_id aoneProductId,\n" +
            "a.aone_product_name aoneProductName, \n" +
            "a.app_score appScore, \n" +
            "a.line_count lineCount,\n" +
            "a.complexity complexity,\n" +
            "a.duplication duplication,\n" +
            "a.comment_rate commentRate,\n" +
            "a.ut_rate utRate,\n" +
            "a.ui_rate uiRate,\n" +
            "a.it_rate itRate,\n" +
            "a.static_code_check_value1 staticCodeCheckValue1,\n" +
            "a.static_code_check_value2 staticCodeCheckValue2,\n" +
            "a.static_code_check_value3 staticCodeCheckValue3,\n" +
            "a.date_stamp dateStamp,\n" +
            "a.deviation deviation,\n" +
            "v.base_value appScoreBaseValue,\n" +
            "b.app_score appScoreRelative,\n" +
            "b.complexity complexityRelative,\n" +
            "b.duplication duplicationRelative,\n" +
            "b.comment_rate commentRateRelative,\n" +
            "b.ut_rate utRateRelative,\n" +
            "b.ui_rate uiRateRelative,\n" +
            "b.it_rate itRateRelative,\n" +
            "b.static_code_check_value1 staticCodeCheckValue1Relative,\n" +
            "b.static_code_check_value2 staticCodeCheckValue2Relative,\n" +
            "b.static_code_check_value3 staticCodeCheckValue3Relative\n" +
            "FROM quality_data_of_app a\n" +
            "LEFT JOIN quality_data_app_base_value v on a.app_id = v.app_id\n" +
            "LEFT JOIN quality_data_of_app b ON a.app_id = b.app_id \n" +
            "AND a.date_stamp = \n" +
            "(SELECT  max(date_stamp) FROM quality_data_of_app)\n" +
            "AND b.date_stamp = \n" +
            "(SELECT  date_add(max(date_stamp), INTERVAL -1 DAY) FROM quality_data_of_app) \n" +
            "WHERE a.date_stamp = \n" +
            "(SELECT  max(date_stamp) FROM quality_data_of_app) " +
            "<if test='deptNo != null and deptNo != 0 '> AND a.dept_name LIKE " +
            "(SELECT concat( (select dept_name FROM department WHERE dept_no = #{deptNo}),'%')) </if>" +
            "<if test='aoneProductId != null and aoneProductId != 0 '>  AND a.aone_product_id = #{aoneProductId} </if>\n" +
            "ORDER BY lineCount desc " +
            "</script>";
}
