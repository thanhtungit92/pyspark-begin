text_file = sc.textFile("D:\\working\\projects\\workspace\\pyspark-begin\\word_count.txt")

counts = text_file.flatMap(lambda line: line.split(" ")) \
             .map(lambda word: (word, 1)) \
             .reduceByKey(lambda a, b: a + b)
             
counts.saveAsTextFile("D:\\working\\projects\\workspace\\pyspark-begin\\output_word_count")