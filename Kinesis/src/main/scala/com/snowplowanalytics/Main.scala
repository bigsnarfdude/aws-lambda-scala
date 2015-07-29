package com.snowplowanalytics

import java.io.IOException
import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.events.KinesisEvent.KinesisEventRecord
import scala.collection.JavaConversions._

case class DataSchema( 
	dataSchema: Any,
    dataSource: Any,
    parser: Any, 
    metricsSpec: Any, 
    granularitySpec: Any
)

class ProcessKinesisEvents {
    
    import com.fasterxml.jackson.databind.ObjectMapper
    import com.fasterxml.jackson.module.scala.DefaultScalaModule

	val scalaMapper = {  
      new ObjectMapper().registerModule(new DefaultScalaModule)
    }


    def recordHandler(event: KinesisEvent) {
    for (rec <- event.getRecords) {
      val record = new String(rec.getKinesis.getData.array())
      //println(record)
      val dataSchema = scalaMapper.readValue(record, classOf[DataSchema])
      println(dataSchema)
    }
  }
}