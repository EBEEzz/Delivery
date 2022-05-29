package com.githrd.deli.sql;


/**
 * @author	이용현
 * @since	2022/05/25
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.25	-	클래스제작
 * 								담당자 : 이용현
 */

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
	public final int SEL_FRIEND = 1016;
	public final int SEL_MNO = 1017;
	public final int SEL_FRIEND_CHECK = 1018;
	public final int SEL_FRIEND_APPLY = 1019;
	public final int SEL_DELFRIEND_CHECK = 1020;
	public final int SEL_MESSAGE = 1021;
		
	public final int UPDATE_CLICK = 2001;
	public final int UPDATE_REGI = 2002;
	public final int UPDATE_FRIEND = 2003;
	public final int UPDATE_FRIEND_AGREE = 2004;
	public final int UPDATE_FRIEND_TOO = 2005;
	public final int UPDATE_FRIEND_CANCLE = 2006;
	public final int UPDATE_CHAT = 2007;
	public final int UPDATE_MESSAGE = 2008;
	
	public final int DEL_REGI = 3001;
	public final int DEL_FRIEND = 3002;
	
	
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
				buff.append("    aid, mno ");
				buff.append("FROM ");
				buff.append("    regimem r, member m ");
				buff.append("WHERE ");
				buff.append("    abno = ? ");
				buff.append("    AND r.isshow = 'Y' ");
				buff.append("    AND aid = id ");
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
			case SEL_FRIEND : // 실제 등록된 친구 조회
				buff.append("SELECT ");
				buff.append("    frino, id ");
				buff.append("FROM ");
				buff.append("    friend f, member m ");
				buff.append("WHERE ");
				buff.append("    myno = (SELECT mno FROM member WHERE id = ?) ");
				buff.append("    AND frino = mno ");
				buff.append("    AND f.isshow = 'Y' ");
				buff.append("    AND agree = 'Y' ");
				break;
			case SEL_MNO :
				buff.append("SELECT ");
				buff.append("    mno ");
				buff.append("FROM ");
				buff.append("    member ");
				buff.append("WHERE ");
				buff.append("    id = ? ");
				break;
			case SEL_FRIEND_CHECK :
				buff.append("SELECT ");
				buff.append("    COUNT(*) cnt ");
				buff.append("FROM ");
				buff.append("    friend ");
				buff.append("WHERE ");
				buff.append("    myno = (SELECT mno FROM member WHERE id = ?) ");
				buff.append("    AND frino = ? ");
				buff.append("    AND isshow = 'Y' ");
				buff.append("    AND agree = 'N' ");
				break;
			case SEL_FRIEND_APPLY :
				buff.append("SELECT ");
				buff.append("    myno, id ");
				buff.append("FROM ");
				buff.append("    friend f, member m ");
				buff.append("WHERE ");
				buff.append("    myno = mno ");
				buff.append("    AND frino = (SELECT mno FROM member WHERE id = ?) ");
				buff.append("    AND f.isshow = 'Y' ");
				buff.append("    AND agree = 'N' ");
				break;
			case SEL_DELFRIEND_CHECK :
				buff.append("SELECT ");
				buff.append("    COUNT(*) cnt ");
				buff.append("FROM ");
				buff.append("    friend ");
				buff.append("WHERE ");
				buff.append("    myno = (SELECT mno FROM member WHERE id = ?) ");
				buff.append("    AND frino = ? ");
				buff.append("    AND isshow = 'Y' ");
				buff.append("    AND agree = 'Y' ");
				break;
			case SEL_MESSAGE :
				buff.append("SELECT ");
				buff.append("   id, mstitle, msbody, wdate  ");
				buff.append("FROM ");
				buff.append("    message s, member m ");
				buff.append("WHERE ");
				buff.append("    s.isshow = 'Y' ");
				buff.append("    AND s.myno = (SELECT mno FROM member WHERE id = ?) ");
				buff.append("    AND writerno = mno ");
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
			case UPDATE_FRIEND : // 친구 신청 버튼
				buff.append("INSERT INTO ");
				buff.append("    friend(fno, myno, frino) ");
				buff.append("VALUES( ");
				buff.append("    (SELECT NVL(MAX(fno) +1, 1) FROM friend), (SELECT mno FROM member WHERE id = ? ), ? ");
				buff.append(") ");
				break;
			case UPDATE_FRIEND_AGREE : // 친구 수락시 상대방에게도 친구 추가기능 // 앞에 친구번호 뒤에 내번호
				buff.append("INSERT INTO ");
				buff.append("    friend(fno, myno, frino, agree, adate) ");
				buff.append("VALUES( ");
				buff.append("    (SELECT NVL(MAX(fno) +1, 1) FROM friend), (SELECT mno FROM member WHERE id = ?), ?, 'Y', sysdate ");
				buff.append(") ");
				break;
			case UPDATE_FRIEND_TOO : // 친구 수락버튼 // 뒤에 내번호 앞에 친구번호
				buff.append("UPDATE ");
				buff.append("    friend ");
				buff.append("SET ");
				buff.append("    agree = 'Y', ");
				buff.append("    adate = sysdate ");
				buff.append("WHERE ");
				buff.append("    myno = ? ");
				buff.append("    AND frino = (SELECT mno FROM member WHERE id = ?) ");
				break;
			case UPDATE_FRIEND_CANCLE : // 친구수락 거절
				buff.append("UPDATE ");
				buff.append("    friend ");
				buff.append("SET ");
				buff.append("    isshow = 'N', ");
				buff.append("    ddate = sysdate ");
				buff.append("WHERE ");
				buff.append("    myno = ? ");
				buff.append("    AND frino = (SELECT mno FROM member WHERE id = ? ) ");
				buff.append("    AND agree = 'N' ");
				break;
			case UPDATE_CHAT :
				buff.append("INSERT INTO ");
				buff.append("    chat(cno, cmno, cbody) ");
				buff.append("VALUES( ");
				buff.append("    (SELECT NVL(MAX(cno) + 1, 1) FROM chat), ");
				buff.append("    (SELECT mno FROM member WHERE id = ? ), ? ");
				buff.append(") ");
				break;
			case UPDATE_MESSAGE :
				buff.append("INSERT INTO ");
				buff.append("    message(msno, writerno, myno, mstitle, msbody) ");
				buff.append("VALUES( ");
				buff.append("    (SELECT NVL(MAX(msno) + 1, 1) FROM message),  ");
				buff.append("    (SELECT mno FROM member WHERE id = ? ),  ");
				buff.append("    (SELECT mno FROM member WHERE id = ? ), ");
				buff.append("    ? , ? ");
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
			case DEL_FRIEND : // 등록된 친구 삭제 버튼
				buff.append("UPDATE ");
				buff.append("    friend ");
				buff.append("SET ");
				buff.append("    isshow = 'N', ");
				buff.append("    agree = 'N', ");
				buff.append("    ddate = sysdate ");
				buff.append("WHERE ");
				buff.append("    myno = (SELECT mno FROM member WHERE id = ?) ");
				buff.append("    AND frino = ? ");
				buff.append("    AND agree = 'Y' ");
				break;
				// 친구 수락버튼 필요
		}
		
		
		return buff.toString();
	}
}
