package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.delipDB;
import util.delipUtil;
import vo.delipVO;

public class delipDAO {
	private delipUtil util;
	private delipDB db;

	public delipDAO() {
		util = new delipUtil();
	}

	public ArrayList<delipVO> select() {
		ArrayList<delipVO> list = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			db = new delipDB();
			stmt = con.createStatement();
			rs = stmt.executeQuery(db.setString(db.SELECT));
			list = new ArrayList<delipVO>();
			while (rs.next()) {
				delipVO vo = new delipVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setDist(rs.getDouble("dist"));

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

	public delipVO selOne(String name) {
		delipVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			vo = new delipVO();
			db = new delipDB();
			pstmt = con.prepareStatement(db.setString(db.SELONE));
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setDist(rs.getDouble("dist"));
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

	public int insert(delipVO vo) {
		int no = -100;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = util.setCon();
			db = new delipDB();
			pstmt = con.prepareStatement(db.setString(db.INSERT));
			pstmt.setString(1, vo.getName());
			pstmt.setDouble(2, vo.getHere_lat());
			pstmt.setDouble(3, vo.getHere_Lon());
			pstmt.setDouble(4, vo.getLat());
			pstmt.setDouble(5, vo.getLon());
			pstmt.setDouble(6, vo.getDist());
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
