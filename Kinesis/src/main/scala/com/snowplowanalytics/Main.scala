package com.snowplowanalytics

import java.io.IOException
import com.amazonaws.services.lambda.runtime.events.KinesisEvent
import com.amazonaws.services.lambda.runtime.events.KinesisEvent.KinesisEventRecord
import scala.collection.JavaConversions._


class ProcessKinesisEvents {
    def recordHandler(event: KinesisEvent) {
    for (rec <- event.getRecords) {
      println(new String(rec.getKinesis.getData.array()))
    }
  }
}