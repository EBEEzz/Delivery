package com.githrd.deli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.githrd.deli.db.DeliDBCP;
import com.githrd.deli.sql.PaySQL;

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
	
	public int InsertOdt() {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.INSERT_ODT);
		pstmt = db.getPSTMT(con, sql);
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
				
		return cnt;
	}
	
}
