package com.githrd.deli.sql;

public class PcsSQL {
	public final int SEL_LOGIN_CNT 		= 1001;
	public final int SEL_MEMBER_INFO 	= 1002;
	
	public final int DEL_MEMBER 		= 2001;
	
	public final int INSERT_PROFILE 	= 3001;
	
	
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case INSERT_PROFILE:
			buff.append("INSERT INTO IMGFILE ");
			buff.append("VALUES ( ");
			buff.append("    (SELECT NVL(MAX(ano) + 1, 100001) FROM imgfile), ");
			buff.append("    '?', '?', 'Y', sysdate ");
			buff.append("    ) ");
			break;
		case SEL_MEMBER_INFO:
			buff.append("SELECT ");
			buff.append("	mno, id, esti, mail, kakaoid, tel, m.imgfile, oriname ");
			buff.append("FROM ");
			buff.append("	member m, imgfile ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND m.imgfile = ano ");
			buff.append("	AND id = ? ");
			break;
		case DEL_MEMBER:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;
		}
		return buff.toString();
	}
}
