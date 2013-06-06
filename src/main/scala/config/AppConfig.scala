package config

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.core.{SimpleMongoDbFactory, MongoTemplate}
import com.mongodb.Mongo

@Configuration
@EnableMongoRepositories(basePackages = Array("com.jyc.demo.spring.employee"))
class AppConfig {

  @Bean def mongo = new Mongo

  @Bean def mongoDbFactory = new SimpleMongoDbFactory(mongo, "demo_servlet")

  @Bean def mongoTemplate = new MongoTemplate(mongoDbFactory)
}
