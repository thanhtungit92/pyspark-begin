data_file = "D:\\working\\projects\\workspace\\pyspark-begin\\data_spark.csv"

rdd = sc.textFile(data_file)

# exclude header row
rddheader = rdd.first()
header = sc.parallelize([rddheader])
rdd_data = rdd.subtract(header)

csv_data = rdd_data.map(lambda l: l.split(","))
row_data = csv_data.map(lambda p:(
    p[0], 
    p[1],
    int(p[2]),
    int(p[3])
    )
)
data_filter = row_data.filter(lambda x: 7178 == x[3])

data_filter.take(5)