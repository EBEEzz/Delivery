package com.githrd.deli.sql;

public class EunbeeSQL {
	public final int SEL_ID			= 1001;
	public final int SEL_MAIL		= 1002;
	
	public final int EDIT_PASSWORD	= 2001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ID:
			buff.append("SELECT ");
			buff.append("    CONCAT(RPAD(SUBSTR(id, 1, 2), LENGTH(id)-1, '*'), LPAD(SUBSTR(id, LENGTH(id)), 1)) id ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("    AND mail = ? ");
			break;
		case SEL_MAIL:
			buff.append("SELECT ");
			buff.append("    mail ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("    AND id = ? ");
			buff.append("    AND mail = ? ");
			break;
		case EDIT_PASSWORD:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	pw = ? ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			break;
		}
		return buff.toString();
	}
}
