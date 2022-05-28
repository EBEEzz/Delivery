package com.githrd.deli.sql;

public class PcsSQL {
	public final int SEL_LOGIN_CNT 		= 1001;
	public final int SEL_MEMBER_INFO 	= 1002;
	public final int SEL_ID_CNT 		= 1003;
	public final int SEL_PW_CNT 		= 1004;
	
	public final int DEL_MEMBER 		= 2001;
	public final int EDIT_MEMBER		= 2002;
	public final int EDIT_PROFILE		= 2003;
	
	public final int ADD_MEMBER			= 3001;
	public final int ADD_PROFILE 		= 3002;
	
	
	
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
		case SEL_MEMBER_INFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, esti, mail, kakaoid, tel, oriname, dir, addr, pw ");
			buff.append("FROM ");
			buff.append("	member m, imgfile ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND mno = amno ");
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
		case ADD_MEMBER:
			buff.append("INSERT INTO  ");
			buff.append("    MEMBER(mno, name, id, kakaoid, pw, mail, tel, addr) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(max(mno) + 1, 1001) FROM member), ");
			buff.append("    ?, ?, ?, ?, ?, ?, ? ");
			buff.append("    ) ");
			break;
		case ADD_PROFILE:
			buff.append("INSERT INTO ");
			buff.append("    imgfile(ano, amno, oriname, savename, dir) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(max(ano) + 1, 100000) FROM imgfile), ");
			buff.append("    (SELECT mno FROM member WHERE id = ?), ");
			buff.append("    ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case EDIT_MEMBER:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	### ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;
		case EDIT_PROFILE:
			buff.append("UPDATE ");
			buff.append("    imgfile ");
			buff.append("SET ");
			buff.append("    ### ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("    AND amno = (SELECT mno FROM member WHERE id = ?) ");
			break;
		}
		return buff.toString();
	}
}
