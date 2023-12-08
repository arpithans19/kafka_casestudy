package practice

import com.fasterxml.jackson.databind.{JsonDeserializer, JsonSerializer}
import org.apache.kafka.clients.consumer.ConsumerConfig.{BOOTSTRAP_SERVERS_CONFIG, GROUP_ID_CONFIG, KEY_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER_CLASS_CONFIG}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.KafkaException
import org.apache.kafka.common.serialization.StringDeserializer
import practice.ConsumerEx.props

import java.util.Properties

object ProducerEx extends App {

  val props = new Properties()
  props.setProperty(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.setProperty(GROUP_ID_CONFIG, "group-id-3")
  props.setProperty(KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
  props.setProperty(VALUE_DESERIALIZER_CLASS_CONFIG, classOf[JsonSerializer[String]].getName)

  val producer = new KafkaProducer[String, String](props)

  val inputTopic = "Input1"
  var anyVal = true
  try {
    println("pass JSON object ")
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