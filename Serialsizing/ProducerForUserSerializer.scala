package kafka2

import org.apache.kafka.clients.producer.KafkaProducer

import java.util.Properties

object ProducerForUserSerializer   extends App{
  val props: Properties = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "kafka.UserSerializer")
  props.put("acks", "all")
  val producer = new KafkaProducer[String, User](props)
  try {
    producer.flush()
  } finally {
    producer.close()
  }
}
