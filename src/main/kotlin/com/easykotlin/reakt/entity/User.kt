package com.easykotlin.reakt.entity
import javax.persistence.*

/**
 * Created by jack on 2017/4/29.
 */
@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1
    @Column(length = 50, unique = true)
    var username: String = ""
    var password: String = ""
    @ManyToMany(targetEntity = Role::class, fetch = FetchType.EAGER)
    lateinit var roles: Set<Role>

    override fun toString(): String {
        return "User(id=$id, username='$username', password='$password', roles=$roles)"
    }
}
