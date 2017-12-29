package com.easykotlin.reakt

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyTest {

    @Test
    fun test2(){
        val startList = 1..365
        val endList = 1..365
        var count = 0
        for(s in startList){
            for(e in endList){
                if(s<=e){
                    //println("$s ---> $e")
                    count++
                }
            }
        }
        println("Total count: $count")
    }

    @Test
    fun test1(){
        println(sql)
    }

    val sql = "SELECT count(DISTINCT ccr.author)\n" +
            "   FROM aone_statistics_code_commit_record ccr\n" +
            "   JOIN employee e ON ccr.author = e.login_name\n" +
            "   JOIN department dept ON dept.dept_no = e.dept_no\n" +
            "WHERE dept.dept_name LIKE concat((SELECT dept_name FROM department WHERE dept_no = #{deptNo}),'%')\n" +
            "AND ccr.commit_time BETWEEN #{start} AND #{end} ";
}
