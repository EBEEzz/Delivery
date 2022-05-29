package com.githrd.deli.dao;

import java.sql.*;
import java.util.ArrayList;

import com.githrd.deli.db.*;
import com.githrd.deli.sql.*;
import com.githrd.deli.util.PageUtil;
import com.githrd.deli.vo.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	이용현
 * @since	2022.05.25
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.25	-	클래스제작
 * 									담당자 ] 이용현
 *
 */

public class YonghyunDao {
	
	private DeliDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private YonghyunSQL ySQL;

	public YonghyunDao() {
		db = new DeliDBCP();
		ySQL = new YonghyunSQL();
	}

	// 게시판 리스트 불러오는 함수
	public ArrayList<YonghyunVO> getBoardList(String city, PageUtil page) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setInt(2, page.getStartCont());
			pstmt.setInt(3, page.getEndCont());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRno(rs.getInt("rno"));
				yVO.setBno(rs.getInt("bno"));
				yVO.setBmno(rs.getInt("bmno"));
				yVO.setId(rs.getString("id"));
				yVO.setTitle(rs.getString("title"));
				yVO.setBody(rs.getString("body"));
				yVO.setWdate(rs.getDate("wdate"));
				yVO.setWtime(rs.getTime("wdate"));
				yVO.setClick(rs.getInt("click"));
				yVO.setLarea(rs.getString("larea"));
				yVO.setMarea(rs.getString("marea"));
				yVO.setSarea(rs.getString("sarea"));
				yVO.setEnd(rs.getInt("end"));
				yVO.setCategory(rs.getString("category"));
				yVO.setSdate();
				yVO.setEndalert(rs.getDouble("endalert"));
				
				
				list.add(yVO);
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
	
	// 게시판 글 개수 불러오는 함수
	public int getTotalCount(String city) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_TOTALCOUNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			
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
	
	// 게시판 리스트 타이틀 검색 불러오는 함수
	public ArrayList<YonghyunVO> getBoardTitle(String city, String search, PageUtil page) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_BOARD_TITLE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, page.getStartCont());
			pstmt.setInt(4, page.getEndCont());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRno(rs.getInt("rno"));
				yVO.setBno(rs.getInt("bno"));
				yVO.setBmno(rs.getInt("bmno"));
				yVO.setId(rs.getString("id"));
				yVO.setTitle(rs.getString("title"));
				yVO.setBody(rs.getString("body"));
				yVO.setWdate(rs.getDate("wdate"));
				yVO.setWtime(rs.getTime("wdate"));
				yVO.setClick(rs.getInt("click"));
				yVO.setLarea(rs.getString("larea"));
				yVO.setMarea(rs.getString("marea"));
				yVO.setSarea(rs.getString("sarea"));
				yVO.setEnd(rs.getInt("end"));
				yVO.setCategory(rs.getString("category"));
				yVO.setSdate();			
				yVO.setEndalert(rs.getDouble("endalert"));
				
				list.add(yVO);
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
	
	// 게시판 타이틀 개수 불러오는 함수
	public int getTitleCount(String city, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_TOTALTITLE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + body + "%");
			
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
	// 게시판 리스트 내용 검색 불러오는 함수
	public ArrayList<YonghyunVO> getBoardBody(String city, String search, PageUtil page) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_BOARD_BODY);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, page.getStartCont());
			pstmt.setInt(4, page.getEndCont());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRno(rs.getInt("rno"));
				yVO.setBno(rs.getInt("bno"));
				yVO.setBmno(rs.getInt("bmno"));
				yVO.setId(rs.getString("id"));
				yVO.setTitle(rs.getString("title"));
				yVO.setBody(rs.getString("body"));
				yVO.setWdate(rs.getDate("wdate"));
				yVO.setWtime(rs.getTime("wdate"));
				yVO.setClick(rs.getInt("click"));
				yVO.setLarea(rs.getString("larea"));
				yVO.setMarea(rs.getString("marea"));
				yVO.setSarea(rs.getString("sarea"));
				yVO.setEnd(rs.getInt("end"));
				yVO.setCategory(rs.getString("category"));
				yVO.setSdate();			
				yVO.setEndalert(rs.getDouble("endalert"));
				
				list.add(yVO);
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
	
	// 게시판 검색내용 개수 불러오는 함수
	public int getBodyCount(String city, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_TOTALBODY);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + body + "%");
			
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
	// 게시판 작성자 검색 불러오는 함수
	public ArrayList<YonghyunVO> getBoardId(String city, String search, PageUtil page) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_BOARD_ID);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, page.getStartCont());
			pstmt.setInt(4, page.getEndCont());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRno(rs.getInt("rno"));
				yVO.setBno(rs.getInt("bno"));
				yVO.setBmno(rs.getInt("bmno"));
				yVO.setId(rs.getString("id"));
				yVO.setTitle(rs.getString("title"));
				yVO.setBody(rs.getString("body"));
				yVO.setWdate(rs.getDate("wdate"));
				yVO.setWtime(rs.getTime("wdate"));
				yVO.setClick(rs.getInt("click"));
				yVO.setLarea(rs.getString("larea"));
				yVO.setMarea(rs.getString("marea"));
				yVO.setSarea(rs.getString("sarea"));
				yVO.setEnd(rs.getInt("end"));
				yVO.setCategory(rs.getString("category"));
				yVO.setSdate();			
				yVO.setEndalert(rs.getDouble("endalert"));
				
				list.add(yVO);
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
	
	// 게시판 작성자 글 개수 불러오는 함수
	public int getIdCount(String city, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_TOTALID);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + body + "%");
			
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
	// 게시판 지역 검색 불러오는 함수
	public ArrayList<YonghyunVO> getBoardMarea(String city, String search, PageUtil page) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_BOARD_MAREA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, page.getStartCont());
			pstmt.setInt(4, page.getEndCont());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRno(rs.getInt("rno"));
				yVO.setBno(rs.getInt("bno"));
				yVO.setBmno(rs.getInt("bmno"));
				yVO.setId(rs.getString("id"));
				yVO.setTitle(rs.getString("title"));
				yVO.setBody(rs.getString("body"));
				yVO.setWdate(rs.getDate("wdate"));
				yVO.setWtime(rs.getTime("wdate"));
				yVO.setClick(rs.getInt("click"));
				yVO.setLarea(rs.getString("larea"));
				yVO.setMarea(rs.getString("marea"));
				yVO.setSarea(rs.getString("sarea"));
				yVO.setEnd(rs.getInt("end"));
				yVO.setCategory(rs.getString("category"));
				yVO.setSdate();			
				yVO.setEndalert(rs.getDouble("endalert"));
				
				list.add(yVO);
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
	
	// 게시판 검색내용 개수 불러오는 함수
	public int getMareaCount(String city, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_TOTALMAREA);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, city);
			pstmt.setString(2, "%" + body + "%");
			
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
	
	
	// 게시글 불러오는 함수
	public YonghyunVO getBoardForm(int bno) {
		YonghyunVO yVO = new YonghyunVO();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_BOARD_FORM);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			yVO.setBno(rs.getInt("bno"));
			yVO.setBmno(rs.getInt("bmno"));
			yVO.setId(rs.getString("id"));
			yVO.setTitle(rs.getString("title"));
			yVO.setBody(rs.getString("body"));
			yVO.setWdate(rs.getDate("wdate"));
			yVO.setWtime(rs.getTime("wdate"));
			yVO.setClick(rs.getInt("click"));
			yVO.setLarea(rs.getString("larea"));
			yVO.setMarea(rs.getString("marea"));
			yVO.setSarea(rs.getString("sarea"));
			yVO.setEnd(rs.getInt("end"));
			yVO.setCategory(rs.getString("category"));
			yVO.setSdate();
			yVO.setWenddate(rs.getDate("endtime"));
			yVO.setWendtime(rs.getTime("endtime"));
			yVO.setEndtime();
			yVO.setEndalert(rs.getDouble("endalert"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return yVO;
	}
	
	
	// 조회수 업데이트 함수
	public int UpClick(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_CLICK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 공구 신청 접수 확인 함수
	public int getRegiCount(String id, int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_REGI_COUNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, bno);
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
	
	// 공구 신청 접수 함수
	public int UpRegi(int bno, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_REGI);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
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
	
	// 공구 신청 접수 멤버 확인 함수
	public ArrayList<YonghyunVO> getRegiMember(int bno) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_REGI_MEMBER);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			YonghyunVO yVO = new YonghyunVO();
			yVO.setId(rs.getString("aid"));
			yVO.setMno(rs.getInt("mno"));
			list.add(yVO);
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
	
	
	// 공구 신청 취소 요청 함수
	public int DelRegi(int bno, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.DEL_REGI);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
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
	
	// 메인페이지 조회수 높은 게시글 보여주는 함수
	public ArrayList<YonghyunVO> getHotClick() {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_HOT_CLICK);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRno(rs.getInt("rno"));
				yVO.setBno(rs.getInt("bno"));
				yVO.setBmno(rs.getInt("bmno"));
				yVO.setId(rs.getString("id"));
				yVO.setTitle(rs.getString("title"));
				yVO.setBody(rs.getString("body"));
				yVO.setWdate(rs.getDate("wdate"));
				yVO.setWtime(rs.getTime("wdate"));
				yVO.setClick(rs.getInt("click"));
				yVO.setLarea(rs.getString("larea"));
				yVO.setMarea(rs.getString("marea"));
				yVO.setSarea(rs.getString("sarea"));
				yVO.setEnd(rs.getInt("end"));
				yVO.setCategory(rs.getString("category"));
				yVO.setSdate();
				yVO.setEndalert(rs.getDouble("endalert"));
				
				
				list.add(yVO);
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
	
	
	// 게시글 등록시 지정한 식당 가져오는 함수
	public ArrayList<YonghyunVO> getMenu(int bno) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_REST_TYPE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setRname(rs.getString("rname"));
				yVO.setRestno(rs.getInt("restno"));
				yVO.setMname(rs.getString("mname"));
				yVO.setMprice(rs.getInt("mprice"));

				list.add(yVO);
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
	
	// 내가 등록한 친구 정보보기
	public ArrayList<YonghyunVO> getFriend(String id) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_FRIEND);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setFrino(rs.getInt("frino"));
				yVO.setId(rs.getString("id"));

				list.add(yVO);
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
	
	// 친구 등록 함수
	public int UpFriend(String id, int fno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_FRIEND);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, fno);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 친구 삭제 함수
	public int DelFriend(String id, int fno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.DEL_FRIEND);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, fno);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 친구 수락시 상대방에게도 친구 추가기능
	public int UpFriendAgree(String id, int fno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_FRIEND_AGREE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, fno);
			
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	// 친구 수락 함수
	public int UpFriendToo(int fno, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_FRIEND_TOO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, fno);
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
	
	// 회원번호 불러오는 함수
	public YonghyunVO getMno(String id) {
		YonghyunVO yVO = new YonghyunVO();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_MNO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			yVO.setMno(rs.getInt("mno"));

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return yVO;
	}
	
	// 친구 추가 신청 되었는지 확인하는 함수
	public int getFriendCheck(String id, int fno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_FRIEND_CHECK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, fno);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 친구신청 수락 대기 목록
	public ArrayList<YonghyunVO> getFriendApply(String id) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_FRIEND_APPLY);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				YonghyunVO yVO = new YonghyunVO();
				yVO.setFrino(rs.getInt("myno"));
				yVO.setId(rs.getString("id"));

				list.add(yVO);
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
	
	// 등록된 친구 삭제 가능여부 체크
	public int getDelFriendCheck(String id, int fno) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_DELFRIEND_CHECK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, fno);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 친구 수락 거절
	public int getFriendCancle(int fno, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_FRIEND_CANCLE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, fno);
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
	
	
	// 채팅 기록 함수
	public int UpChat(String id, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_CHAT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, body);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	
	// 받은 메세지 확인 함수
	public ArrayList<YonghyunVO> getMessage(String id) {
		ArrayList<YonghyunVO> list = new ArrayList<YonghyunVO>();
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.SEL_MESSAGE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			YonghyunVO yVO = new YonghyunVO();
			yVO.setId(rs.getString("id"));
			yVO.setTitle(rs.getString("mstitle"));
			yVO.setBody(rs.getString("msbody"));
			yVO.setWdate(rs.getDate("wdate"));
			yVO.setWtime(rs.getTime("wdate"));
			yVO.setSdate();
			list.add(yVO);
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

	
	// 메세지 전송 함수
	public int UpMessage(String id, String fid, String title, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = ySQL.getSQL(ySQL.UPDATE_MESSAGE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, fid);
			pstmt.setString(3, title);
			pstmt.setString(4, body);
System.out.println("작동테스트");			
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
