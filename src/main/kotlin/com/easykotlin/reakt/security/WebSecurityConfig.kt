package com.easykotlin.reakt.security

import com.easykotlin.reakt.handler.MyAccessDeniedHandler
import com.easykotlin.reakt.service.MyUserDetailService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.access.AccessDeniedHandler

/**
prePostEnabled :决定Spring Security的前注解是否可用 [@PreAuthorize,@PostAuthorize,..]
secureEnabled : 决定是否Spring Security的保障注解 [@Secured] 是否可用
jsr250Enabled ：决定 JSR-250 annotations 注解[@RolesAllowed..] 是否可用.
 */

@Configuration
@EnableWebSecurity
// 开启 Spring Security 方法级安全
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun myAccessDeniedHandler(): AccessDeniedHandler {
        return MyAccessDeniedHandler("/403")
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return MyUserDetailService()
    }

//    http://127.0.0.1:8004/article-list.js

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
            .antMatchers(
                    "/js/**",
                    "/css/**"
            ).permitAll() // 不拦截js,css
            .anyRequest().authenticated()
            .and()
            .formLogin()
            //.loginPage("/login")// url 请求路径，对应 LoginController 里面的 @GetMapping("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/index").permitAll()
            .and()
            .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler())
//            .exceptionHandling().accessDeniedPage("/403")
            .and()
            .logout().permitAll()

        http.logout().logoutSuccessUrl("/")

    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        //AuthenticationManager 使用我们的 lightSwordUserDetailService 来获取用户信息
        auth.userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder())
    }

    /**
     * 密码加密算法
     *
     * @return
     */
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder();
    }
}
