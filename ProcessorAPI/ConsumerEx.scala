package day3

import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}

import java.util
import java.util.Properties
import scala.jdk.CollectionConverters.IterableHasAsScala

object ConsumerEx {
  val outputTopic ="WordCountOutput"
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer")
  props.put("group.id", "consumer-t")
  props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest")

  val consumer = new KafkaConsumer[String, java.lang.Long](props)

  //serializable list,immutable list
  consumer.subscribe(util.Collections.singletonList(outputTopic))

  while (true) {
    val records = consumer.poll(10)
    for (record <- records.asScala) {

      println(record.key() + " : " + record.value())
    }
  }
}
