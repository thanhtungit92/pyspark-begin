package com.postgre

import java.sql.{Connection, DriverManager}

object UpdateData {
  def main(args: Array[String]): Unit = {
    var sql_connection: Connection = null
    Class.forName("org.postgresql.Driver")
    sql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "921891tung")
    val prepare_statement_add_column = sql_connection.prepareStatement(s"UPDATE students SET age = ? WHERE name = ?")
    prepare_statement_add_column.setInt(1, 30);
    prepare_statement_add_column.setString(2, "hoang");
    prepare_statement_add_column.executeUpdate()
    prepare_statement_add_column.close()
    sql_connection.close();
  }
}
