package kafka2

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.Properties
import scala.collection.JavaConverters._

object ConsumerForUserDeserialiser extends App {
  val prop: Properties = new Properties()
  prop.put("group.id", "test")
  prop.put("bootstrap.servers", "localhost:9092")
  prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  prop.put("value.deserializer", "kafka.UserDeserializer")
  prop.put("enable.auto.commit", "true")
  prop.put("auto.commit.interval.ms", "1000")
  val consumer = new KafkaConsumer[String, User](prop)
  val topics = List("user_user")
  try {
    consumer.subscribe(topics.asJava)
    while (true) {
      val records = consumer.poll(10)
      records.forEach(e=>println(e))
    }
    }
    finally
    {
      consumer.close()
    }
  }