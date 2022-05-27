package com.githrd.deli.sql;

public class PaySQL {
	public final int INSERT_ODT			=	1001;
	public final int INSERT_ODL			=	1002;
	public final int INSERT_ODM			=	1003;
	
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
			buff.append("    orderlist(olno, ono, rno, oprice, paym, requests, gorder) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(olno) +1, 1) FROM orderlist),  ");
			buff.append("  ?, ?, ?, ?, ?, 111111 ");
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
		}
		return buff.toString();
	}
}
