//package com.lqc.zufang.config;
//
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author liqicong@myhexin.com
// * @date 2019/3/22 15:13
// */
//@Configuration
//@EnableCaching
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.formLogin().loginPage("/gotoLogin").loginProcessingUrl("/login").failureUrl("/test").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
////                .and()
////                .authorizeRequests().anyRequest().authenticated()
////                .and()
////                .csrf().disable();
//    }
//}
