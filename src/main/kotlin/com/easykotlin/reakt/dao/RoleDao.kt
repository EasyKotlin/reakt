package com.easykotlin.reakt.dao

import com.easykotlin.reakt.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDao : JpaRepository<Role, Long> {
}
