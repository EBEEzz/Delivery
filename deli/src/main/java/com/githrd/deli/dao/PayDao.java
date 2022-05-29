package com.githrd.deli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public PayVO getPay(int bno) {
		PayVO pVO = new PayVO();
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.SEL_PAYS);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			pVO.setRno(rs.getInt("restno"));
			pVO.setDelpay(rs.getInt("delpay"));
			pVO.setMprice(rs.getInt("mprice"));
			pVO.setMname(rs.getString("mname"));
			
			
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		db.close(rs);
		db.close(pstmt);
		db.close(con);
	}
		
		
		return pVO;
	}
	
	public int getAbnoCnt(int abno) {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.ABNO_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, abno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt("cnt");
			
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		db.close(rs);
		db.close(pstmt);
		db.close(con);
	}
		return cnt;
	}
	
	public PayVO getMINFO(String id) {
		PayVO pVO = new PayVO();
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.SEL_MINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			pVO.setMembmno(rs.getInt("mno"));
			pVO.setId(rs.getString("id"));
			pVO.setMembtel(rs.getString("tel"));
			pVO.setMembaddr(rs.getString("addr"));
			pVO.setMembmail(rs.getString("mail"));
			pVO.setMembname(rs.getString("name"));
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return pVO;
	}
	
	public ArrayList<PayVO> getRest(int bno) {
		 ArrayList<PayVO> list = new  ArrayList<PayVO>();
		 con = db.getCon();
		 String sql = pSQL.getSQL(pSQL.SEL_REST);
		 pstmt = db.getPSTMT(con, sql);
		 try {
			 pstmt.setInt(1, bno);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 PayVO pVO = new PayVO();
				 pVO.setRname(rs.getString("rname"));
				 pVO.setRestno(rs.getInt("restno"));
				 pVO.setMname(rs.getString("mname"));
				 pVO.setMprice(rs.getInt("mprice"));
				 pVO.setQuantity(rs.getInt("quantity"));
				 
				 list.add(pVO);
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
}
