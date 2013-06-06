package config

import org.springframework.context.annotation.{Configuration, ComponentScan}
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct
import config.mongo.MongoSetupFixture

@EnableWebMvc
@Configuration
@ComponentScan(value = Array("config.mongo", "com.jyc.demo.spring.employee"))
class WebConfig {

  @Autowired val setupFixture: MongoSetupFixture = null

  @PostConstruct
  def doSetup {
    setupFixture.setup
  }
}


