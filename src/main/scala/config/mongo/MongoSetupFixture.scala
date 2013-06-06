package config.mongo

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import com.jyc.demo.spring.employee.{EmployeeMongoRepository, Employee}

@Component
class MongoSetupFixture {
  @Autowired val repo: EmployeeMongoRepository = null

  def setup {
    val testDocQuery = Option(repo.findByLastName("Buwalda"))
    testDocQuery match {
      case Some(doc) => //do nothing, its already there
      case None => {
        repo.save(Employee(firstName = "Nate", lastName = "Buwalda", title = "Consultant", age = 34, salary = 123456.78))
      }
    }
  }
}
