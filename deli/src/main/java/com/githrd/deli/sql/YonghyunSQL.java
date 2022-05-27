package com.githrd.deli.sql;

public class YonghyunSQL {
	public final int SEL_BOARD = 1001;
	public final int SEL_TOTALCOUNT = 1002;
	public final int SEL_BOARD_TITLE = 1003;
	public final int SEL_TOTALTITLE = 1004;
	public final int SEL_BOARD_BODY = 1005;
	public final int SEL_TOTALBODY = 1006;
	public final int SEL_BOARD_ID = 1007;
	public final int SEL_TOTALID = 1008;
	public final int SEL_BOARD_MAREA = 1009;
	public final int SEL_TOTALMAREA = 1010;
	public final int SEL_BOARD_FORM = 1011;
	public final int SEL_REGI_COUNT = 1012;
	public final int SEL_REGI_MEMBER = 1013;
	public final int SEL_HOT_CLICK = 1014;
	public final int SEL_REST_TYPE = 1015;
		
	public final int UPDATE_CLICK = 2001;
	public final int UPDATE_REGI = 2002;
	
	public final int DEL_REGI = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
			case SEL_BOARD :
				buff.append("SELECT ");
				buff.append("    rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("FROM ");
				buff.append("    (SELECT ");
				buff.append("       rownum rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("    FROM ");
				buff.append("        (SELECT ");
				buff.append("            bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("        FROM ");
				buff.append("           board b, member m ");
				buff.append("        WHERE ");
				buff.append("            larea = ? ");
				buff.append("            AND b.isshow = 'Y' ");
				buff.append("            AND bmno = mno ");
				buff.append("        ORDER BY ");
				buff.append("            wdate desc ");
				buff.append("        ) ");
				buff.append("    ) ");
				buff.append("WHERE ");
				buff.append("    rno BETWEEN ? AND ? ");
				break;
			case SEL_BOARD_TITLE :
				buff.append("SELECT ");
				buff.append("    rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("FROM ");
				buff.append("    (SELECT ");
				buff.append("       rownum rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("    FROM ");
				buff.append("        (SELECT ");
				buff.append("            bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("        FROM ");
				buff.append("            board b, member m ");
				buff.append("        WHERE ");
				buff.append("            larea = ? ");
				buff.append("            AND b.isshow = 'Y' ");
				buff.append("            AND bmno = mno ");
				buff.append("            AND title LIKE ? ");
				buff.append("        ORDER BY ");
				buff.append("            wdate desc ");
				buff.append("        ) ");
				buff.append("    ) ");
				buff.append("WHERE ");
				buff.append("    rno BETWEEN ? AND ? ");
				break;
			case SEL_TOTALTITLE :
				buff.append("SELECT ");
				buff.append("   count(*) cnt ");
				buff.append("FROM ");
				buff.append("    board b, member m ");
				buff.append("WHERE ");
				buff.append("    larea = ? ");
				buff.append("    AND b.isshow = 'Y' ");
				buff.append("    AND bmno = mno ");
				buff.append("    AND title LIKE ? ");
				break;
			case SEL_BOARD_BODY :
				buff.append("SELECT ");
				buff.append("    rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("FROM ");
				buff.append("    (SELECT ");
				buff.append("       rownum rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("    FROM ");
				buff.append("        (SELECT ");
				buff.append("            bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("        FROM ");
				buff.append("            board b, member m ");
				buff.append("        WHERE ");
				buff.append("            larea = ? ");
				buff.append("            AND b.isshow = 'Y' ");
				buff.append("            AND bmno = mno ");
				buff.append("            AND body LIKE ? ");
				buff.append("        ORDER BY ");
				buff.append("            wdate desc ");
				buff.append("        ) ");
				buff.append("    ) ");
				buff.append("WHERE ");
				buff.append("    rno BETWEEN ? AND ? ");
				break;
			case SEL_TOTALBODY :
				buff.append("SELECT ");
				buff.append("   count(*) cnt ");
				buff.append("FROM ");
				buff.append("    board b, member m ");
				buff.append("WHERE ");
				buff.append("    larea = ? ");
				buff.append("    AND b.isshow = 'Y' ");
				buff.append("    AND bmno = mno ");
				buff.append("    AND body LIKE ? ");
				break;
			case SEL_BOARD_ID :
				buff.append("SELECT ");
				buff.append("    rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("FROM ");
				buff.append("    (SELECT ");
				buff.append("       rownum rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("    FROM ");
				buff.append("        (SELECT ");
				buff.append("            bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("        FROM ");
				buff.append("            board b, member m ");
				buff.append("        WHERE ");
				buff.append("            larea = ? ");
				buff.append("            AND b.isshow = 'Y' ");
				buff.append("            AND bmno = mno ");
				buff.append("            AND id LIKE ? ");
				buff.append("        ORDER BY ");
				buff.append("            wdate desc ");
				buff.append("        ) ");
				buff.append("    ) ");
				buff.append("WHERE ");
				buff.append("    rno BETWEEN ? AND ? ");
				break;
			case SEL_TOTALID :
				buff.append("SELECT ");
				buff.append("   count(*) cnt ");
				buff.append("FROM ");
				buff.append("    board b, member m ");
				buff.append("WHERE ");
				buff.append("    larea = ? ");
				buff.append("    AND b.isshow = 'Y' ");
				buff.append("    AND bmno = mno ");
				buff.append("    AND id LIKE ? ");
				break;
			case SEL_BOARD_MAREA :
				buff.append("SELECT ");
				buff.append("    rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("FROM ");
				buff.append("    (SELECT ");
				buff.append("       rownum rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("    FROM ");
				buff.append("        (SELECT ");
				buff.append("            bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("        FROM ");
				buff.append("            board b, member m ");
				buff.append("        WHERE ");
				buff.append("            larea = ? ");
				buff.append("            AND b.isshow = 'Y' ");
				buff.append("            AND bmno = mno ");
				buff.append("            AND marea LIKE ? ");
				buff.append("        ORDER BY ");
				buff.append("            wdate desc ");
				buff.append("        ) ");
				buff.append("    ) ");
				buff.append("WHERE ");
				buff.append("    rno BETWEEN ? AND ? ");
				break;
			case SEL_TOTALMAREA :
				buff.append("SELECT ");
				buff.append("   count(*) cnt ");
				buff.append("FROM ");
				buff.append("    board b, member m ");
				buff.append("WHERE ");
				buff.append("    larea = ? ");
				buff.append("    AND b.isshow = 'Y' ");
				buff.append("    AND bmno = mno ");
				buff.append("    AND marea LIKE ? ");
				break;
			case SEL_TOTALCOUNT :
				buff.append("SELECT ");
				buff.append("    count(*) cnt ");
				buff.append("FROM ");
				buff.append("    board ");
				buff.append("WHERE ");
				buff.append("    larea = ? ");
				break;
			case SEL_BOARD_FORM :
				buff.append("SELECT ");
				buff.append("    bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, (wdate + (end/24)) endtime, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("FROM ");
				buff.append("    board b, member m ");
				buff.append("WHERE ");
				buff.append("    bmno = mno ");
				buff.append("    AND bno = ? ");
				break;
			case SEL_REGI_COUNT :
				buff.append("SELECT ");
				buff.append("    COUNT(*) cnt ");
				buff.append("FROM ");
				buff.append("    regimem ");
				buff.append("WHERE ");
				buff.append("    aid = ? ");
				buff.append("    AND abno = ? ");
				buff.append("    AND isshow = 'Y' ");
				break;
			case SEL_REGI_MEMBER :
				buff.append("SELECT ");
				buff.append("    aid ");
				buff.append("FROM ");
				buff.append("    regimem ");
				buff.append("WHERE ");
				buff.append("    abno = ? ");
				buff.append("    AND isshow = 'Y' ");
				break;
			case SEL_HOT_CLICK :
				buff.append("SELECT ");
				buff.append("    rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("FROM ");
				buff.append("    (SELECT ");
				buff.append("       rownum rno, bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, endalert ");
				buff.append("    FROM ");
				buff.append("        (SELECT ");
				buff.append("            bno, bmno, id, title, body, wdate, click, larea, marea, sarea, end, category, ((wdate + (end/24)) - sysdate) endalert ");
				buff.append("       FROM ");
				buff.append("           board b, member m ");
				buff.append("        WHERE ");
				buff.append("            b.isshow = 'Y' ");
				buff.append("            AND bmno = mno ");
				buff.append("       ORDER BY ");
				buff.append("            click desc ");
				buff.append("        ) ");
				buff.append("    ) ");
				buff.append("WHERE ");
				buff.append("    rno BETWEEN 1 AND 5 ");
				break;
			case SEL_REST_TYPE :
				buff.append("SELECT ");
				buff.append("    rname, restno, mname, mprice ");
				buff.append("FROM ");
				buff.append("    board b, restaurant r, menu m ");
				buff.append("WHERE ");
				buff.append("    b.rest = r.restno ");
				buff.append("    AND m.rno = r.restno ");
				buff.append("    AND bno = ? ");
				break;
			case UPDATE_CLICK :
				buff.append("UPDATE ");
				buff.append("    board ");
				buff.append("SET ");
				buff.append("    click = click + 1 ");
				buff.append("WHERE ");
				buff.append("    bno = ? ");
				break;
			case UPDATE_REGI :
				buff.append("INSERT INTO ");
				buff.append("    regimem(abno, aid) ");
				buff.append("VALUES( ");
				buff.append("    ?, ? ");
				buff.append(") ");
				break;
			case DEL_REGI :
				buff.append("UPDATE ");
				buff.append("    regimem ");
				buff.append("SET ");
				buff.append("    isshow = 'N', ");
				buff.append("    wdate = wdate ");
				buff.append("WHERE ");
				buff.append("    isshow = 'Y' ");
				buff.append("    AND ABNO = ? ");
				buff.append("    AND AID = ? ");
				break;
		}
		
		
		return buff.toString();
	}
}
