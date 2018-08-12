from pyspark.sql import Row

data_file = "D:\\working\\projects\\workspace\\pyspark-begin\\data_spark.csv"

rddheader = rdd.first()
header = sc.parallelize([rddheader])
rdd_data = rdd.subtract(header)

csv_data = rdd_data.map(lambda l: l.split(","))
row_data = csv_data.map(lambda p: Row(
    name=p[0], 
    email=p[1],
    age=int(p[2]),
    salary=int(p[3])
    )
)

people_infor_df = sqlContext.createDataFrame(row_data)
# people_infor_df.registerTempTable("people_infor")

# tcp_people_infor = sqlContext.sql("""
#     SELECT name, email, age FROM interactions WHERE age < 20 and salary > 4000
# """)
# tcp_people_infor.show()
