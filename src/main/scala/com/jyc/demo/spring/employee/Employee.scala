package com.jyc.demo.spring.employee

import scala.beans.BeanProperty
import org.bson.types.ObjectId

case class Employee(@BeanProperty id: ObjectId = null,
                    @BeanProperty firstName: String,
                    @BeanProperty lastName: String,
                    @BeanProperty title: String,
                    @BeanProperty age: Int,
                    @BeanProperty salary: Double)
