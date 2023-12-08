//package day3
//
//import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
//import org.apache.kafka.common.KafkaException
//
//import java.util.Properties
//
//object ProducerEx {
//
//  import org.apache.kafka.clients.producer.KafkaProducer
//  import org.apache.kafka.clients.producer.Producer
//  import org.apache.kafka.clients.producer.ProducerConfig
//  import org.apache.kafka.clients.producer.ProducerRecord
//
//  val props = new Properties()
//  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
//  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
//  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer")
//  props.put("schema.registry.url", "http://127.0.0.1:8081")
//
//  val producer = new KafkaProducer[String, String](props)
//
//  val topic = "testjsonschema"
//  val key = "testkey"
//  val user = user("John", "Doe", 33)
//
//  val record = new ProducerRecord[String, String](topic, key, user)
//  producer.send(record).get
//
//}
