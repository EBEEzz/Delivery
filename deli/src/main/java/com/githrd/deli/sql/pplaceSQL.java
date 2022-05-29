package com.githrd.deli.sql;

public class pplaceSQL {
	public final int SELECT = 1000;
	public final int SELONE = 1001;
	public final int INSERT = 1002;
	public final int SELID = 1003;
	public final int SELECT_MYLOCATION = 1004;
	

	public String setString(int code) {
		StringBuffer buff = new StringBuffer();
		switch (code) {
		case SELECT:
			buff.append("select cusname, cusid, pickuplat, pickuplon, cus_lat, cus_lon, distance ");
			buff.append("from pickupPlace ");
			buff.append("order by distance asc ");

			break;
		case SELID:
			buff.append("select cusname, cusid, pickuplat, pickuplon, cus_lat, cus_lon, distance ");
			buff.append("from pickupPlace ");
			buff.append("where cusid = ? ");
			buff.append("order by distance asc ");
			break;

		case SELONE:
			buff.append("select cusname, cusid, pickuplat, pickuplon, cus_lat, cus_lon, distance ");
			buff.append("from pickupPlace ");
			buff.append("order by distance asc ");
			break;

		case INSERT:
			buff.append("insert into pickupPlace ");
			buff.append("values ( ? , ? , ? , ? , ? , ? , ?  ) ");
			break;
			
		case SELECT_MYLOCATION:
			buff.append("SELECT ");
			buff.append("    pickuplat, pickuplon, cus_lat, cus_lon ");
			buff.append("FROM ");
			buff.append("    pickupplace ");
			buff.append("WHERE ");
			buff.append("    cusid = ? ");
			break;

		}
		return buff.toString();
	}

}
