package com.ritesh.SpringBatch.MultiThreadedJob;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.ritesh.SpringBatch.MultiThreadedJob.Record;

public class PSSetter implements ItemPreparedStatementSetter<Record> {

	@Override
	public void setValues(Record record, PreparedStatement ps)
			throws SQLException {
		  ps.setInt(1, record.getID());
		  ps.setString(2, record.getNAME());
		  
		  
	}

}
