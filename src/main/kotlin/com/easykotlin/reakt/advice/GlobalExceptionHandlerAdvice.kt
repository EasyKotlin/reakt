package com.easykotlin.reakt.advice

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice(basePackages = arrayOf("com.ksb.ksb_with_shiro"))
class GlobalExceptionHandlerAdvice {

    /**表示捕捉到 Exception的异常*/
    @ExceptionHandler(value = Exception::class)
    fun exception(exception: Exception, model: Model): String {
        model.addAttribute("errorMessage", exception.message)
        model.addAttribute("stackTrace", exception.stackTrace)
        return "/error"
    }
}
