package com.jyc.demo.spring.employee

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMethod, RequestMapping, ResponseBody}

@Controller
class EmployeeController {
  import RequestMethod._

  @RequestMapping(value = Array("/employee"), method = Array(GET))
  @ResponseBody
  def showEmployees() = "get works"

  @RequestMapping(value = Array("/employee"), method = Array(POST))
  @ResponseBody
  def addNewEmployee() = "post works"
}
