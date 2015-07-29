package com.snowplowanalytics

import java.io.IOException
import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.events.KinesisEvent.KinesisEventRecord
import scala.collection.JavaConversions._

case class DataSource(dataSource: Map[String,Any])
case class Parser(parser: Map[String, Any])
case class MetricsSpec(metricsSpec: Any) 
case class GranularitySpec(granularitySpec: Any)
case class DataSchema(dataSchema:Map[String, Map[dataSource:DataSource, parser:Parser, metricsSpec:MetricsSpec, granularitySpec:GranularitySpec])

class ProcessKinesisEvents {
    
    import com.fasterxml.jackson.databind.ObjectMapper
    import com.fasterxml.jackson.module.scala.DefaultScalaModule

    val scalaMapper = {  
      new ObjectMapper().registerModule(new DefaultScalaModule)
    }

    def recordHandler(event: KinesisEvent) {
    for (rec <- event.getRecords) {
      val record = new String(rec.getKinesis.getData.array())
      val dataSchema = scalaMapper.readValue(record, classOf[DataSchema])
      println(dataSchema)
    }
  }
}

