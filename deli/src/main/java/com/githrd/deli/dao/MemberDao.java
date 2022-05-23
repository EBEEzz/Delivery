package com.githrd.deli.dao;

import java.sql.*;

import com.githrd.deli.db.*;
import com.githrd.deli.sql.*;
import com.githrd.deli.vo.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	안은비
 * @since	2022.05.23
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.23	-	클래스제작
 * 									담당자 ] 안은비
 *
 */

public class MemberDao {
	
	private DeliDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberSQL mSQL;

	public MemberDao() {
		db = new DeliDBCP();
		mSQL = new MemberSQL();
	}

}
