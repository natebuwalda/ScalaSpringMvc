package com.jyc.demo.spring.employee

import org.bson.types.ObjectId
import org.springframework.data.repository.CrudRepository
import org.springframework.beans.factory.annotation.Autowired
import collection.JavaConversions._
import org.springframework.stereotype.Component

trait EmployeeService {
  def listEmployees: List[Employee]
  def totalSalary: Double
  def addNewEmployee(employee: Employee): Option[(String, Employee)]
}

@Component
class EmployeeMongoService extends EmployeeService {
  @Autowired val repo: EmployeeMongoRepository = null

  def listEmployees: List[Employee] = repo.findAll().toList

  def totalSalary: Double = {
    repo.findAll().foldLeft(0.0)((total, employee) => total + employee.salary)
  }

  def addNewEmployee(employee: Employee): Option[(String, Employee)] = {
    val saveResult: Employee = repo.save(employee)
    saveResult match {
      case savedEmployee: Employee => Option((employee.id.toString, employee))
      case _ => None
    }
  }
}

trait EmployeeMongoRepository extends CrudRepository[Employee, ObjectId] {
  def findByLastName(lastName: String): Employee
}
