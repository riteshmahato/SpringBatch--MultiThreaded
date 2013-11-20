package com.ritesh.SpringBatch.MultiThreadedJob;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Record,Record> {

	@Override
	public Record process(Record rIn) throws Exception {
		//Processing Logic
		rIn.setNAME("ProcessedAGAIN");
		return rIn;
	}
	
}
