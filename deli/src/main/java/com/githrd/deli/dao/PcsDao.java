package com.githrd.deli.dao;

import java.sql.*;

import com.githrd.deli.db.*;
import com.githrd.deli.sql.*;
import com.githrd.deli.vo.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	박찬슬
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	회원 테이블 전담 함수 추가
 * 									담당자 ] 박찬슬
 * 				2022.05.25	-	회원 테이블 전담 함수 추가2
 * 									담당자 ] 박찬슬
 * 				2022.05.26	-	회원 테이블 전담 함수 추가2
 * 									담당자 ] 박찬슬
 * 
 *
 */

public class PcsDao {
	
	private DeliDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private PcsSQL pSQL;

	public PcsDao() {
		db = new DeliDBCP();
		pSQL = new PcsSQL();
	}
	
	// 로그인 데이터베이스작업 전담 처리함수
		public int getLogin(String id, String pw) {
			int cnt = 0;
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = pSQL.getSQL(pSQL.SEL_LOGIN_CNT);
			// 명령전달도구
			pstmt = db.getPSTMT(con, sql);
			try {
				// 질의명령 완성
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				// 질의명령 보내고 결과받고
				rs = pstmt.executeQuery();
				// 결과에서 데이터꺼내고
				rs.next();
				cnt = rs.getInt("cnt");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			// 데이터 내보내고
			return cnt;
		}
	
	// 회원번호로 회원 정보 조회 전담 처리함수
	public PcsVO getIdInfo(String id) {
		PcsVO pVO = new PcsVO();
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.SEL_MEMBER_INFO);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 꺼내서 VO에 담고
			rs.next();
			pVO.setMno(rs.getInt("mno"));
			pVO.setName(rs.getString("name"));
			pVO.setId(rs.getString("id"));
			pVO.setEsti(rs.getDouble("esti"));
			pVO.setMail(rs.getString("mail"));
			pVO.setKakaoid(rs.getString("kakaoid"));
			pVO.setTel(rs.getString("tel"));
			pVO.setOriname(rs.getString("oriname"));
			pVO.setDir(rs.getString("dir"));
			pVO.setAddr(rs.getString("addr"));
	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 반환
		return pVO;
	}
	
	// 회원탈퇴 데이터베이스작업 전담 처리함수
	public int delMember(int mno) {
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.DEL_MEMBER);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, mno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	
	
	// 회원가입 데이터베이스 작업 전담 처리함수
	public int addMember(PcsVO pVO) {
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.ADD_MEMBER);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하고
			pstmt.setString(1, pVO.getName());
			pstmt.setString(2, pVO.getId());
			pstmt.setString(3, pVO.getKakaoid());
			pstmt.setString(5, pVO.getMail());
			pstmt.setString(6, pVO.getTel());
			pstmt.setString(7, pVO.getAddr());
			
			// 질의명령 보내고 결과받고
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 반환
		return cnt;
	}
	
	// 회원가입시 프로필사진 데이터베이스 작업 전담 함수
	public int addProfile(FileVO fVO) {
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.ADD_PROFILE);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, fVO.getId());
			pstmt.setString(2, fVO.getOriname());
			pstmt.setString(3, fVO.getSavename());
			pstmt.setString(4, fVO.getDir());
			// 결과보내고 받고
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 아이디 카운트 조회 전담 처리함수
	public int getIdCount(String id) {
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.SEL_ID_CNT);
		// 명령전달도구 준비
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 보내고 결과받고
			rs = pstmt.executeQuery();
			// 레코드포인터 한줄 내리고
			rs.next();
			
			// 데이터꺼내서 변수에 담고
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 반환하고
		return cnt;
	}
	
	
	// 회원정보수정 데이터베이스 작업 전담 처리함수
	public int editMyInfo(int mno, String esql) {
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.EDIT_MEMBER);
		// 질의명령 수정하고
		sql = sql.replace("###", esql);
		
		// 명령 전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, mno);
			// 질의명령 보내고 결과받고
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		// 결과 반환하고
		return cnt;
	}
	
	public int editProFile(String id,  String fsql) {
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = pSQL.getSQL(pSQL.EDIT_PROFILE);
		// 질의명령 수정하고
		sql = sql.replace("###", fsql);
		
		// 명령 전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하고
			pstmt.setString(1, id);
			// 질의명령 보내고 결과받고
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 결과 반환하고
		return cnt;
	}
	
}
