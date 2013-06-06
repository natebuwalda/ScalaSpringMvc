package com.jyc.demo.spring.employee

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestBody, RequestMethod, RequestMapping, ResponseBody}
import org.springframework.beans.factory.annotation.Autowired
import collection.JavaConversions._
import scala.beans.BeanProperty
import com.jyc.demo.spring.common.Json

@Controller
class EmployeeController {
  import RequestMethod._

  @Autowired val employeeService: EmployeeService = null

  @RequestMapping(value = Array("/employee"), method = Array(GET))
  @ResponseBody
  def showEmployees(): java.util.List[Employee] = employeeService.listEmployees

  @RequestMapping(value = Array("/employee"), method = Array(POST))
  @ResponseBody
  def addNewEmployee(@RequestBody rawEmployee: String): ResultMessage = {
    import Json._

    val insertResult = employeeService.addNewEmployee(fromJson(rawEmployee, classOf[Employee]))
    insertResult match {
      case Some((id, doc)) => EmployeeResultMessage("Added obj id %s".format(id), doc)
      case None => EmployeeErrorMessage("insert failed")
    }
  }
}

sealed trait ResultMessage {
  val message: String
}
case class EmployeeResultMessage(@BeanProperty message: String, @BeanProperty document: Employee) extends ResultMessage

sealed trait ErrorMessage extends ResultMessage
case class EmployeeErrorMessage(@BeanProperty message: String) extends ErrorMessage
