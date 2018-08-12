from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("My App")
sc = SparkContext(conf = conf)

a = sc.textFile("README.md").filter(lambda line: "Spark" in line) 
a.saveAsTextFile("c:\\spark\\file2")

