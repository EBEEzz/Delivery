package com.githrd.deli.dao;

import java.sql.*;
import java.util.*;

import com.githrd.deli.db.*;
import com.githrd.deli.sql.*;
import com.githrd.deli.vo.*;

/**
 * 이 클래스는 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	안은비
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 				2022.05.24	-	getId()
 * 				2022.05.25	-	getMail()
 * 				2022.05.26	-	editPw()
 * 				2022.05.27	-	getAbno()
 * 				2022.05.27	-	getAid()
 * 				2022.05.28	-	addEstiInfo()
 * 				2022.05.28	-	getNewEsti()
 * 									담당자 ] 안은비
 *
 */

public class EunbeeDao {
	
	private DeliDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private EunbeeSQL eSQL;

	public EunbeeDao() {
		db = new DeliDBCP();
		eSQL = new EunbeeSQL();
	}
	
	public String getId(String mail) {
		String mid = null;
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.SEL_ID);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mid = rs.getString("id");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mid;
	}
	
	public String getMail(String id, String mail) {
		String mmail = null;
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.SEL_MAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, mail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mmail = rs.getString("mail");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return mmail;
	}
	
	public int editPw(String pw, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.EDIT_PASSWORD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	public int getAbno(String id) {
		int mbno = 0;
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.SEL_ABNO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mbno = rs.getInt("abno");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mbno;
	}
	
	public ArrayList<EunbeeVO> getAid(int bno, String id) {
		ArrayList<EunbeeVO> list = new ArrayList<EunbeeVO>();
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.SEL_ESTIINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EunbeeVO eVO = new EunbeeVO();
				eVO.setId(rs.getString("aid"));
				eVO.setEsti(rs.getDouble("esti"));
				eVO.setDir(rs.getString("dir"));
				eVO.setSavename(rs.getString("savename"));
				
				list.add(eVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	public int addEstiInfo(EunbeeVO eVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.ADD_ESTIINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, eVO.getBno());
			pstmt.setString(2, eVO.getId());
			pstmt.setString(3, eVO.getIdb());
			pstmt.setDouble(4, eVO.getPoint());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	public EunbeeVO getNewEsti(String id) {
		EunbeeVO eVOp = new EunbeeVO();
		con = db.getCon();
		String sql = eSQL.getSQL(eSQL.SEL_NEWESTI);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			
			eVOp.setSpts(rs.getDouble("spts"));
			eVOp.setCpts(rs.getInt("cpts"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return eVOp;
	}
	
	

}
