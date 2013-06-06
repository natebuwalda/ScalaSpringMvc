package com.jyc.demo.spring.employee

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMethod, RequestMapping, ResponseBody}
import org.springframework.beans.factory.annotation.Autowired
import collection.JavaConversions._

@Controller
class EmployeeController {
  import RequestMethod._

  @Autowired val employeeService: EmployeeService = null

  @RequestMapping(value = Array("/employee"), method = Array(GET))
  @ResponseBody
  def showEmployees(): java.util.List[Employee] = employeeService.listEmployees

  @RequestMapping(value = Array("/employee"), method = Array(POST))
  @ResponseBody
  def addNewEmployee() = "post works"
}
