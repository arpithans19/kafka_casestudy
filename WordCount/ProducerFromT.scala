package WordCount

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.KafkaException

import java.util.Properties

object ProducerFromT extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val inputTopic = "InputTopic"
  var anyVal = true
  try {
    println("Type something  : ")
    while (anyVal) {
      val input = scala.io.StdIn.readLine()
      val record = new ProducerRecord(inputTopic, "key", input)
      producer.send(record)
      if (input == "stop") anyVal = false
    }
  }
  catch {
    case e: KafkaException => e.printStackTrace()
  }
  finally {
    producer.close()
  }
}