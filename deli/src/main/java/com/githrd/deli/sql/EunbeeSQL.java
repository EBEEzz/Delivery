package com.githrd.deli.sql;

public class EunbeeSQL {
	public final int SEL_ID			= 1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ID:
			buff.append("SELECT ");
			buff.append("    id ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("    AND mail = ? ");
			break;
		}
		return buff.toString();
	}
}
