package practice

//import kafka.ConsumerClass.consumerProperties
import com.fasterxml.jackson.databind.JsonDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig.{BOOTSTRAP_SERVERS_CONFIG, GROUP_ID_CONFIG, KEY_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER_CLASS_CONFIG}
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.common.serialization.{IntegerDeserializer, StringDeserializer, StringSerializer}

import java.util
import java.util.Properties
import scala.collection.JavaConverters._

object ConsumerEx extends App {
  val outputTopic ="Output1"
  val props = new Properties()
//  props.put("bootstrap.servers", "localhost:9092")

  props.setProperty(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.setProperty(GROUP_ID_CONFIG, "group-id-3")
  props.setProperty(KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
  props.setProperty(VALUE_DESERIALIZER_CLASS_CONFIG, classOf[JsonDeserializer[String]].getName)

  val consumer = new KafkaConsumer[String, String](props)

  //serializable list,immutable list
  consumer.subscribe(util.Collections.singletonList(outputTopic))

  while (true) {
    val records = consumer.poll(10)
    for (record <- records.asScala) {

      println(record.key() + " : " + record.value())
    }
  }
}