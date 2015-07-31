package com.snowplowanalytics

import java.io.IOException
import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.events.KinesisEvent.KinesisEventRecord
import scala.collection.JavaConversions._

// Either[DataSource,ParserSpec,TimestampSpecColumn,TimestampSpecFormat])
case class DataSource(dataSource: String)
case class DataSchema(dataSchema: DataSource) 
case class ParserType(`type`: String)
case class ParserSpec(parser: ParseSpecFormat)
case class ParseSpecFormat(format: String)
case class ParseSpec(parseSpec: ParseSpecFormat)
case class TimestampSpecColumn(column: String)
case class TimestampSpecFormat(format: String)
case class TimestampSpec(timestampSpec: Either[TimestampSpecColumn,TimestampSpecFormat])
case class MetricUnit(`type`: String, name: String, fieldName: Option[String] = None)
case class MetricsSpec(metricsSpec: List[MetricUnit])
case class QueryGranularity(queryGranularity: String)
case class GranularitySpec(granularitySpec: QueryGranularity)


class ProcessKinesisEvents {
    
    import com.fasterxml.jackson.databind.ObjectMapper
    import com.fasterxml.jackson.module.scala.DefaultScalaModule

    val scalaMapper = {  
      new ObjectMapper().registerModule(new DefaultScalaModule)
    }

    def recordHandler(event: KinesisEvent) {
	    for (rec <- event.getRecords) {
	      val record = new String(rec.getKinesis.getData.array())
	      val dataSchema = scalaMapper.readValue(record, classOf[MetricsSpec])
	      println(dataSchema)
	    }
	}
}

