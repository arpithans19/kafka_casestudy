package kafka

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization._

import java.util.Properties

object ProducerClass extends App {

  val topicName = "TestTopic"

  val producerProperties = new Properties()
  producerProperties.setProperty(
    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"
  )
  producerProperties.setProperty(
    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[IntegerSerializer].getName
  )
  producerProperties.setProperty(
    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName
  )

  val producer = new KafkaProducer[Int, String](producerProperties)

  producer.send(new ProducerRecord[Int, String](topicName, 10, "Java,S1"))
  producer.send(new ProducerRecord[Int, String](topicName, 20, "CSS,S2"))
  producer.send(new ProducerRecord[Int, String](topicName, 30, "HTML,S3"))
  producer.send(new ProducerRecord[Int, String](topicName, 40, "Scala,S4"))
  producer.send(new ProducerRecord[Int, String](topicName, 50, "Akka,S5"))
  producer.send(new ProducerRecord[Int, String](topicName,60, "ReactJS,S6"))
  producer.flush()
  producer.close()



}
