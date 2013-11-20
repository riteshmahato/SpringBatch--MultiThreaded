package com.ritesh.SpringBatch.MultiThreadedJob;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class SynchronisedReader implements ItemReader<Record>, ItemStream {

	private ItemReader<Record> delegate;
	@Override
	public void close() throws ItemStreamException {
		if (this.delegate instanceof ItemStream) {
            ((ItemStream)this.delegate).close();
		}
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		if (this.delegate instanceof ItemStream) {
            ((ItemStream)this.delegate).open(executionContext);
		}
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		 if (this.delegate instanceof ItemStream) {
	            ((ItemStream)this.delegate).update(executionContext);
	    }
	}

	@Override
	public synchronized Record read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		return delegate.read();
	}

	public ItemReader<Record> getDelegate() {
		return delegate;
	}

	public void setDelegate(ItemReader<Record> delegate) {
		this.delegate = delegate;
	}
	
}
