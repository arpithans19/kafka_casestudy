//package day3
//
//
//
//  import org.apache.kafka.streams.KeyValue
//  import org.apache.kafka.streams.processor.PunctuationType
//  import org.apache.kafka.streams.state.KeyValueIterator
//  import org.apache.kafka.streams.state.KeyValueStore
//  import java.time.Duration
//
//  class WordCountProcessor extends Nothing {
//    private var context = null
//    private var kvStore = null
//
//    @SuppressWarnings(Array("unchecked")) def init(context: Nothing): Unit = { // keep the processor context locally because we need it in punctuate() and commit()
//      this.context = context
//      // retrieve the key-value store named "Counts"
//      kvStore = context.getStateStore("Counts").asInstanceOf[KeyValueStore[_, _]]
//      // schedule a punctuate() method every second based on stream-time
//      this.context.schedule(Duration.ofSeconds(1000), PunctuationType.STREAM_TIME, (timestamp) => {
//        def foo(timestamp) = {
//          val iter = this.kvStore.all
//          while ( {
//            iter.hasNext
//          }) {
//            val entry = iter.next
//            context.forward(entry.key, entry.value.toString)
//          }
//          iter.close()
//          // commit the current processing progress
//          context.commit
//        }
//
//        foo(timestamp)
//      })
//    }
//
//    def punctuate(timestamp: Long): Unit = {
//      // this method is deprecated and should not be used anymore
//    }
//
//    def close(): Unit = {
//      // close any resources managed by this processor
//      // Note: Do not close any StateStores as these are managed by the library
//    }
//
//}
