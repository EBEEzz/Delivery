package com.githrd.deli.sql;

/**
 * 이 클래스는 질의명렁을 전담해서 처리하는 클래스
 * @author	안은비
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 				2022.05.24	-	SEL_ID
 * 				2022.05.25	-	SEL_MAIL
 * 				2022.05.26	-	EDIT_PASSWORD
 * 				2022.05.27	-	SEL_ABNO
 * 				2022.05.27	-	SEL_NEWESTI
 * 				2022.05.28	-	ADD_ESTIINFO	-오류
 * 				2022.05.28	-	ADD_ESTI
 * 				2022.05.28	-	SEL_NEWESTI
 * 				2022.05.28	-	UPDATE_ESTI
 * 				2022.05.28	-	SEL_REGMEM
 * 									담당자 ] 안은비
 *
 */

public class EunbeeSQL {
	public final int SEL_ID			= 1001;
	public final int SEL_MAIL		= 1002;
	public final int SEL_ABINFO		= 1003;
	public final int SEL_ESTIINFO	= 1004;
	public final int SEL_NEWESTI	= 1005;
	public final int SEL_REGMEM		= 1006;
	
	public final int EDIT_PASSWORD	= 2001;

	//public final int ADD_ESTIINFO	= 3001;
	public final int ADD_ESTI		= 3002;
	public final int UPDATE_ESTI	= 3003;
	
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
		case SEL_ABINFO:
			buff.append("SELECT ");
			buff.append("    abno, title, wd ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            abno, title, b.wdate wd ");
			buff.append("        FROM ");
			buff.append("           regimem r, board b ");
			buff.append("        WHERE ");
			buff.append("            r.abno = b.bno ");
			buff.append("            AND r.isshow = 'Y' ");
			buff.append("            AND aid = ? ");
			buff.append("    ) ");
			break;
		case SEL_ESTIINFO:
			buff.append("SELECT ");
			buff.append("    DISTINCT ");
			buff.append("        ebno, eida, eidb, epoint, show, dir, savename ");
			buff.append("FROM ");
			buff.append("    estimate e, imgfile i, member m, ( ");
			buff.append("		SELECT ");
			buff.append("			e.isshow show ");
			buff.append("		FROM ");
			buff.append("			estimate e ");
			buff.append("	) ");
			buff.append("WHERE ");
			buff.append("    e.isshow = 'Y' ");
			buff.append("    AND eida = ? ");
			buff.append("    AND eidb != ? ");
			buff.append("    AND ebno = ? ");
			break;
		/*
		case ADD_ESTIINFO:
			buff.append("INSERT INTO ");
			buff.append("    estimate(ebno, eida, eidb) ");
			buff.append("VALUES( ");
			buff.append("    ?, ?, ? ");
			buff.append(") ");
			break;
		*/
		case ADD_ESTI:
			buff.append("UPDATE ");
			buff.append("    estimate ");
			buff.append("SET ");
			buff.append("    epoint = ?, ");
			buff.append("    isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("    ebno = ? ");
			buff.append("    AND eida = ? ");
			buff.append("    AND eidb = ? ");
			break;
		case SEL_NEWESTI:
			buff.append("SELECT ");
			buff.append("    spts, cpts ");
			buff.append("FROM ");
			buff.append("    estimate, ( ");
			buff.append("        SELECT ");
			buff.append("            SUM(epoint) spts, count(epoint) cpts ");
			buff.append("        FROM ");
			buff.append("            estimate ");
			buff.append("        WHERE ");
			buff.append("            eidb = ? ");
			buff.append("            AND isshow = 'N' ");
			buff.append("    ) ");
			break;
		case UPDATE_ESTI:
			buff.append("UPDATE ");
			buff.append("    member ");
			buff.append("SET ");
			buff.append("    esti = ? ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
			break;
		case SEL_REGMEM:
			buff.append("SELECT ");
			buff.append("    aid ");
			buff.append("FROM ");
			buff.append("    regimem ");
			buff.append("WHERE ");
			buff.append("    abno = ? ");
			buff.append("    AND isshow = 'Y' ");
			break;
		
		}
		return buff.toString();
	}
}
