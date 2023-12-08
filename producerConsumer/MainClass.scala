//
//package practice
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.scala.{DefaultScalaModule, ScalaObjectMapper}
//import org.apache.kafka.streams.StreamsConfig
//
//import java.util.Properties
//
//object MainClass extends App {
//
//  val props: Properties = {
//    val p = new Properties()
//    p.put(StreamsConfig.APPLICATION_ID_CONFIG, "streamApplication")
//    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
//    p
//  }
//  val outputTopic = "Output1"
//
//  // keep the processor context locally because we need it in punctuate() and commit()
//  def init(context: Nothing): Unit = {
//
//  }
//
//  val mapper = new ObjectMapper() with ScalaObjectMapper
//  mapper.registerModule(DefaultScalaModule)
//
//
//  def toJson(value: Map[Symbol, Any]): String = {
//    toJson(value map { case (k, v) => k.name -> v })
//  }
//
//  def toJson(value: Any): String = {
//    mapper.writeValueAsString(value)
//  }
//
//  def mean(): Unit = {
//    val i=outputTopic.toList
////    val j=i.indexOf(2)
//    val mean=i.sum/i.length
//
//
//
//  }
//
//  def process() {
//
//    // add a header to the elements
//
//
//    import org.apache.kafka.streams.Topology
//    val builder = new Topology
//    builder.addSource("Source", "Output1")
//      .addSink("Sink", "Output1", "Process")
//
//
//    val t = outputTopic.split(",").mkString.split(":").mkString
//
//
////    t match {
////      case 1 =>
////        outputTopic.toList.size
////        println()
////    }
//
//  }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////The code starts by creating a new KTable called textLines.
////This is the table that will hold all of the lines in the text file.
////The code then uses flatMapValues to iterate over each line, and splits it into words using toLowerCase.
////Next, groupBy is used to create an array of strings with one string for each word in the original list.
////Finally, count() is used on this array of strings to get its length (the number of items) and store that value as counts-store.
////The next step is to use streamTo() on materialized-store which will produce a stream containing all values from counts-store sorted by their frequency (count).
////The code will count all words in the text file and then print them out to the console.