package config

import org.springframework.context.annotation.{Configuration, ComponentScan}
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@Configuration
@ComponentScan(value = Array("com.jyc.demo.spring.employee"))
class AppConfig {

}
