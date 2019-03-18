package com.simdy.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        //定制请求的规则
        http.authorizeRequests().antMatchers("/").permitAll();

        //开启自动配置登录功能,如果没有权限就到登录界面
        ///login到登录页
        //重定向到/login?error表示登录失败
        //更多详细规则
        http.formLogin().usernameParameter("user").passwordParameter("password")
                .loginPage("/login");
        http.formLogin();
//        http.formLogin().loginPage("/login");


        //访问loginout表示注销功能
        http.logout();

        // 记住密码cookies
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("simdy").password(new BCryptPasswordEncoder().encode("111111")).roles("Vip");

    }
}
