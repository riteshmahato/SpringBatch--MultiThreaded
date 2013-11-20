package com.ritesh.SpringBatch.MultiThreadedJob;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ritesh.SpringBatch.MultiThreadedJob.Record;

public class ReaderRowMapper implements RowMapper<Record> {

	public static final String ID = "ID";
	public static final String NAME = "NAME";
	
	public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
		Record record = new Record();
		
		record.setID(rs.getInt(ID));
		record.setNAME(rs.getString(NAME));
		
		return record;
	}

}
