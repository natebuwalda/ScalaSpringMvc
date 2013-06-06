package com.jyc.demo.spring.main

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import config.{AppConfig, WebConfig}
import org.springframework.web.context.ContextLoaderListener

object Starter extends App {
  val server = new Server(8081)

  val servletHolder = new ServletHolder(new DispatcherServlet());
  servletHolder.setInitParameter("contextClass", classOf[AnnotationConfigWebApplicationContext].getName);
  servletHolder.setInitParameter("contextConfigLocation", classOf[WebConfig].getName);

  val context = new ServletContextHandler()
  context.addEventListener(new ContextLoaderListener())
  context.setInitParameter("contextClass", classOf[AnnotationConfigWebApplicationContext].getName)
  context.setInitParameter("contextConfigLocation", classOf[AppConfig].getName)
  context.setContextPath( "/" )
  context.addServlet(servletHolder, "/api-spring/*")

  server.setHandler(context)
  server.start()
  server.join()
}
