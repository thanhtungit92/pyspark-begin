package com.postgre

import java.sql.{Connection, DriverManager}

import scala.collection.mutable.ListBuffer

object GetData {
  def printList(args: ListBuffer[_]): Unit = {
    args.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    var sql_connection: Connection = null
    Class.forName("org.postgresql.Driver")
    sql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "921891tung")
    val statement = sql_connection.createStatement()
    val resultSet = statement.executeQuery("select * from students")
    var students = new ListBuffer[Students]()
    while ( resultSet.next() ) {
      val student = new Students(resultSet.getString("name"),resultSet.getInt("age"), resultSet.getString("description"))
      students += student
    }
    printList(students)

    sql_connection.close();
  }
}
