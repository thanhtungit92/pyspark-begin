package com.postgre

import java.sql.{Connection, DriverManager}

object InsertData {
  def main(args: Array[String]): Unit = {
    var sql_connection: Connection = null
    Class.forName("org.postgresql.Driver")
    sql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "921891tung")
    val student = new Students("hoang", 23, "test describe")
    val prepare_statement_add_column = sql_connection.prepareStatement(s"INSERT INTO  students (name, age, description) VALUES (?,?,?)")
    prepare_statement_add_column.setString(1, student.name)
    prepare_statement_add_column.setInt(2, student.age)
    prepare_statement_add_column.setString(3, student.description)
    prepare_statement_add_column.executeUpdate()
    prepare_statement_add_column.close()
    sql_connection.close();
  }
}
