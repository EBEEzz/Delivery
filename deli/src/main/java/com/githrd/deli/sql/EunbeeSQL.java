package com.githrd.deli.sql;

public class EunbeeSQL {
	public final int SEL_ID			= 1001;
	public final int SEL_MAIL		= 1002;
	public final int SEL_ABNO		= 1003;
	public final int SEL_ESTIINFO		= 1004;
	
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
		case SEL_ABNO:
			buff.append("SELECT ");
			buff.append("    abno ");
			buff.append("FROM ");
			buff.append("    regimem ");
			buff.append("WHERE ");
			buff.append("    aid = ? ");
			break;
		case SEL_ESTIINFO:
			buff.append("SELECT ");
			buff.append("    aid, esti, dir, savename ");
			buff.append("FROM ");
			buff.append("    regimem r, member m, imgfile i ");
			buff.append("WHERE ");
			buff.append("    r.aid = m.id ");
			buff.append("    AND m.mno = i.amno ");
			buff.append("    AND r.isshow = 'Y' ");
			buff.append("    AND m.isshow = 'Y' ");
			buff.append("    AND i.isshow = 'Y' ");
			buff.append("    AND abno = ? ");
			buff.append("    AND aid != ? ");
			break;
		}
		return buff.toString();
	}
}
