package com.githrd.deli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.githrd.deli.sql.pplaceSQL;
import com.githrd.deli.util.DButil;
import com.githrd.deli.vo.pplaceVO;

public class pplaceDAO {
	private DButil util = new DButil();
	private pplaceSQL sql;

	public pplaceDAO() {
	}

	public ArrayList<pplaceVO> select() {
		ArrayList<pplaceVO> list = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			sql = new pplaceSQL();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.setString(sql.SELECT));
			list = new ArrayList<pplaceVO>();
			while (rs.next()) {
				pplaceVO vo = new pplaceVO();
				vo.setCusname(rs.getString("cusname"));
				vo.setCusid(rs.getString("cusid"));
				vo.setPickuplat(rs.getDouble("pickuplat"));
				vo.setPickuplon(rs.getDouble("pickuplon"));
				vo.setCus_lat(rs.getDouble("cus_lat"));
				vo.setCus_lat(rs.getDouble("cus_lon"));
				vo.setDistance(rs.getDouble("distance"));
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

	public ArrayList<pplaceVO> seleID(String id) {
		ArrayList<pplaceVO> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			sql = new pplaceSQL();
			pstmt = con.prepareStatement(sql.setString(sql.SELID));
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			list = new ArrayList<pplaceVO>();
			while (rs.next()) {
				pplaceVO vo = new pplaceVO();
				vo.setCusname(rs.getString("cusname"));
				vo.setCusid(id);
				vo.setPickuplat(rs.getDouble("pickuplat"));
				vo.setPickuplon(rs.getDouble("pickuplon"));
				vo.setCus_lat(rs.getDouble("cus_lat"));
				vo.setCus_lat(rs.getDouble("cus_lon"));
				vo.setDistance(rs.getDouble("distance"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);

		}
		return list;
	}

	public pplaceVO selOne(String name) {
		pplaceVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = util.setCon();
			vo = new pplaceVO();
			sql = new pplaceSQL();
			pstmt = con.prepareStatement(sql.setString(sql.SELONE));
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setCusname(rs.getString("cusname"));
				vo.setCusid(rs.getString("cusid"));
				vo.setPickuplat(rs.getDouble("pickuplat"));
				vo.setPickuplon(rs.getDouble("pickuplon"));
				vo.setCus_lat(rs.getDouble("cus_lat"));
				vo.setCus_lat(rs.getDouble("cus_lon"));
				vo.setDistance(rs.getDouble("distance"));
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

	public double chooseId(String id, int num) {
		double db = 0.0;
		String[] idlist = { "YHLEE", "dool", "hui", "HONG", "call", "jennie", "aeb320" };
		double[] lat = { 126.91951962334, 126.96167029999923, 126.95403900000007, 126.97787669999931,
				126.97212219999993, 127.00048369999965, 126.90804280599 };
		double[] lon = { 37.50064696263, 37.575384699999816, 37.576780899999754, 37.56390500000024, 37.550392700000224,
				37.55489750000009, 37.498628104654 };

		for (int i = 0; i < idlist.length; i++) {
			if (id.equals(idlist[i])) {
				if (num == 1) {
					db = lat[i];
				}
				if (num == 2) {
					db = lon[i];
				}
			}
		}
		return db;
	}

	public int insert(pplaceVO vo) {
		int no = -100;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			sql = new pplaceSQL();
			con = util.setCon();
			pstmt = con.prepareStatement(sql.setString(sql.INSERT));
			pstmt.setString(1, vo.getCusname());
			pstmt.setString(2, vo.getCusid());
			pstmt.setDouble(3, vo.getPickuplat());
			pstmt.setDouble(4, vo.getPickuplon());
			pstmt.setDouble(5, vo.getCus_lat());
			pstmt.setDouble(6, vo.getCus_lon());
			pstmt.setDouble(7, vo.getDistance());
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
