package com.githrd.deli.sql;

public class PaySQL {
	public final int INSERT_ODT			=	1001;
	public final int INSERT_ODL			=	1002;
	public final int INSERT_ODM			=	1003;
	
	public final int SEL_PAYS			=	2001;
	public final int SEL_MINFO			=	2002;
	
	public final int ABNO_CNT			=	3001;
			
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case INSERT_ODT:
			buff.append("INSERT INTO ");
			buff.append("    ordertask(ono, mno) ");
			buff.append("VALUES( ");
			buff.append("    ?, ? ");
			buff.append(") ");
			break;
		case INSERT_ODL:
			buff.append("INSERT INTO ");
			buff.append("    orderlist(olno, ono, rno, oprice, paym, requests) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(olno) +1, 1) FROM orderlist),  ");
			buff.append("  ?, ?, ?, ?, ? ");
			buff.append(" ) ");			
			break;
		case INSERT_ODM:
			buff.append("INSERT INTO ");
			buff.append("    ordermenu(omno, olno, omenu, omprice, quantity, ono) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(omno) + 1, 1) FROM ordermenu),  ");
			buff.append(" 	 (SELECT olno FROM orderlist WHERE ono = ? ), ");
			buff.append(" ?, ?, ?, ? ");
			buff.append(") ");				
			break;
		case SEL_PAYS:
			buff.append("SELECT ");
			buff.append("    restno, delpay, mprice, mname ");
			buff.append("FROM ");
			buff.append("    board b, restaurant r, menu m ");
			buff.append("WHERE ");
			buff.append("    b.isshow = 'Y' ");
			buff.append("    AND r.isshow = 'Y' ");
			buff.append("    AND m.isshow = 'Y' ");
			buff.append("    AND m.rno = r.restno ");
			buff.append("    AND bno = ? ");
			break;
		case SEL_MINFO:
			buff.append("SELECT ");
			buff.append("    mno, id, tel, addr, mail, name ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("    AND id = ? ");
			break;
		case ABNO_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    regimem ");
			buff.append("WHERE ");
			buff.append("    isshow = 'Y' ");
			buff.append("    AND abno = ? ");
			break;
		}
		return buff.toString();
	}
}
