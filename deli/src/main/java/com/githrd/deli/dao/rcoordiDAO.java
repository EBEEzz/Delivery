package com.githrd.deli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.githrd.deli.sql.rcoordiDB;
import com.githrd.deli.util.DButil;
import com.githrd.deli.vo.rcoordiVO;

/**
 * 이 클래스는 데이터베이스 작업을 전담해서 처리하는 클래스
 * 
 * @author 고하늘
 * @since 2022.05.29
 * @version v.1.0
 * 
 *          작업이력 ] 2022.05.28 - 클래스제작 * 2022.05.28 - getResno() 2022.05.28 -
 *          getResname() 2022.05.28 - getReslat() 2022.05.28 - getReslon()
 *          2022.05.28 - getResdist() 2022.05.28 - getCategory() 2022.05.28 -
 *          getCate_no() 담당자 ] 고하늘
 *
 */

public class rcoordiDAO {
	private DButil util;
	private rcoordiDB db;

	public rcoordiDAO() {
		util = new DButil();
	}

	//
	public ArrayList<rcoordiVO> select() {
		ArrayList<rcoordiVO> list = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			db = new rcoordiDB();
			stmt = con.createStatement();
			rs = stmt.executeQuery(db.setString(db.SELECT));
			list = new ArrayList<rcoordiVO>();
			while (rs.next()) {

				rcoordiVO vo = new rcoordiVO();
				vo.setResno(rs.getInt("resno"));
				vo.setResname(rs.getString("resname"));
				vo.setReslat(rs.getDouble("reslat"));
				vo.setReslon(rs.getDouble("reslon"));
				vo.setMylat(rs.getDouble("mylat"));
				vo.setMylon(rs.getDouble("mylon"));
				vo.setResdist(rs.getDouble("resdist"));
				vo.setCategory(rs.getString("category"));
				vo.setCate_no(rs.getInt("cate_no"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			close(rs);
			close(stmt);
			close(con);

		}
		return list;
	}

	public rcoordiVO selOne(String name) {
		rcoordiVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			vo = new rcoordiVO();
			db = new rcoordiDB();
			pstmt = con.prepareStatement(db.setString(db.SELONE));
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setResno(rs.getInt("resno"));
				vo.setResname(rs.getString("resname"));
				vo.setReslat(rs.getDouble("reslat"));
				vo.setReslon(rs.getDouble("reslon"));
				vo.setMylat(rs.getDouble("mylat"));
				vo.setMylon(rs.getDouble("mylon"));
				vo.setResdist(rs.getDouble("resdist"));
				vo.setCategory(rs.getString("category"));
				vo.setCate_no(rs.getInt("cate_no"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			close(rs);
			close(pstmt);
			close(con);

		}
		return vo;
	}

	public int insert(rcoordiVO vo) {
		int no = -100;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = util.setCon();
			db = new rcoordiDB();
			pstmt = con.prepareStatement(db.setString(db.INSERT));
			pstmt.setString(1, vo.getResname());
			pstmt.setDouble(2, vo.getReslat());
			pstmt.setDouble(3, vo.getReslon());
			pstmt.setDouble(4, vo.getMylat());
			pstmt.setDouble(5, vo.getMylat());
			pstmt.setDouble(6, vo.getResdist());
			pstmt.setString(7, vo.getCategory());
			pstmt.setInt(8, vo.getCate_no());
			no = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);

		}
		return no;
	}

	public void close(Object o) {
		if (o instanceof ResultSet) {
			try {
				((ResultSet) o).close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (o instanceof Statement) {
				try {
					((Statement) o).close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (o instanceof Connection) {
				try {
					((Connection) o).close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
