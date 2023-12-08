//package Practice2
//
//import Practice2.MarshallableImplicits.Marshallable
//import com.fasterxml.jackson.databind.{JsonDeserializer, ObjectMapper}
//import com.fasterxml.jackson.module.scala.{DefaultScalaModule, ScalaObjectMapper}
//import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
//import org.apache.kafka.common.KafkaException
//import org.apache.kafka.common.serialization.IntegerSerializer
//
//import java.util.Properties
//
//object producer extends App {
//
//  val p= Person("11")
//
//  val p1 = p.toJson
//  // jeroenJson:  String = {"name":"Jeroen","age":26}
//
////  val jeroenMap = jeroenJson.toMap
//
//  val props = new Properties()
//  props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"
//  )
//  props.setProperty(
//    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[IntegerSerializer].getName
//  )
//  props.setProperty(
//    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[JsonDeserializer[Person]].getName
//  )
//
//
//
//    val mapper = new ObjectMapper() with ScalaObjectMapper
//    mapper.registerModule(DefaultScalaModule)
//    def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)
//
//    def fromJson[T](json: String)(implicit m : Manifest[T]): T = {
//      mapper.readValue[T](json)
//    }
//
//
//  val producer = new KafkaProducer[String, String](props)
//
//  val inputTopic = "Input1"
//  var anyVal = true
//  try {
//    println("Type something  : ")
//    while (anyVal) {
//      val input = scala.io.StdIn.readLine()
//      val record = new ProducerRecord(inputTopic, "key", input)
//      producer.send(record)
//      if (input == "stop") anyVal = false
//    }
//  }
//  catch {
//    case e: KafkaException => e.printStackTrace()
//  }
//  finally {
//    producer.close()
//  }
//}