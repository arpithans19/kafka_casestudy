
package WordCount

import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala.Serdes._
import org.apache.kafka.streams.scala._
import org.apache.kafka.streams.scala.kstream._
import org.apache.kafka.streams.{KafkaStreams, StreamsConfig}

import java.util.Properties

object WordCountStream extends App {

  val props: Properties = {
    val p = new Properties()
    p.put(StreamsConfig.APPLICATION_ID_CONFIG, "streamApplication")
    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    p
  }

  val outputTopic = "WordCountOutput"

  //entry point
  val builder: StreamsBuilder = new StreamsBuilder
  val textLines: KStream[String, String] = builder.stream[String, String]("InputTopic")

  //  table- hold all of the lines in the text file.
  val wordCounts: KTable[String, Long] = textLines
    .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
    .groupBy((_, word) => word)
    .count()(Materialized.as("counts-store"))
  wordCounts.toStream.to(outputTopic)

  val streams: KafkaStreams = new KafkaStreams(builder.build(), props)
  streams.start()

//   initialized but unstarted thread
  sys.ShutdownHookThread {
    streams.close()

  }

}























//The code starts by creating a new KTable called textLines.
//This is the table that will hold all of the lines in the text file.
//The code then uses flatMapValues to iterate over each line, and splits it into words using toLowerCase.
//Next, groupBy is used to create an array of strings with one string for each word in the original list.
//Finally, count() is used on this array of strings to get its length (the number of items) and store that value as counts-store.
//The next step is to use streamTo() on materialized-store which will produce a stream containing all values from counts-store sorted by their frequency (count).
//The code will count all words in the text file and then print them out to the console.