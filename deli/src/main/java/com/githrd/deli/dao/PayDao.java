package com.githrd.deli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.githrd.deli.db.DeliDBCP;
import com.githrd.deli.sql.PaySQL;
import com.githrd.deli.vo.PayVO;

/**
 * 결제를 위한 Dao
 * @author 이형준
 * @since  2022.05.25
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.23	-	클래스제작
 * 									담당자 ] 이형준	
 */

public class PayDao {

	private DeliDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private PaySQL pSQL;

	public PayDao() {
		db = new DeliDBCP();
		pSQL = new PaySQL();
	}
	
	public int InsertOdt(String ono, int mno) {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.INSERT_ODT);
		pstmt = db.getPSTMT(con, sql);
		try {
				pstmt.setString(1, ono);
				pstmt.setInt(2, mno);
				cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
				
		return cnt;
	}
	
	public int InsertOdl(PayVO pVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.INSERT_ODL);
		pstmt = db.getPSTMT(con, sql);
		try {
				pstmt.setString(1, pVO.getOno());
				pstmt.setInt(2, pVO.getRno());
				pstmt.setInt(3, pVO.getOprice());
				pstmt.setString(4, pVO.getPaym());
				
				
				if(pVO.getRequest() == null) {
					pstmt.setString(5, "없음");
				} else {
					pstmt.setString(5, pVO.getRequest());
				}
				
				cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
				
		return cnt;
	}
	
	public int InsertOdm(PayVO pVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.INSERT_ODM);
		pstmt = db.getPSTMT(con, sql);
		try {
				pstmt.setString(1, pVO.getOno());
				pstmt.setString(2, pVO.getOmenu());
				pstmt.setInt(3, pVO.getOmprice());
				pstmt.setInt(4, pVO.getQuantity());
				pstmt.setString(5, pVO.getOno());
				
				System.out.println(pVO);
				cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
				
		return cnt;
	}
}
