package com.sparkPostgre

import org.apache.spark.sql.SparkSession

object TestConnection {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder().master("local[2]")
      .appName("Postgre test")
      .getOrCreate()

    val jdbcDF = spark.read
      .format("jdbc")
      .option("url", "jdbc:postgresql://localhost:5432/postgres")
      .option("dbtable", "students")
      .option("user", "postgres")
      .option("password", "921891tung")
      .load()

    jdbcDF.select("name").show();
  }
}
