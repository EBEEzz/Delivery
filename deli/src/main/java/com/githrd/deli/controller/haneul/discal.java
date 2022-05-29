package com.githrd.deli.controller.haneul;

import java.text.NumberFormat;

public class discal {

	// 지도상 위도, 경도 거리 계산해주는 클래스

	public double disCal(double lat1, double lon1, double lat2, double lon2) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		dist = dist * 1609.344;
		dist = Double.parseDouble(cutDecimal(2, dist));
		return dist;
	};

	public String cutDecimal(int cutSize, double value) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(cutSize);
		nf.setGroupingUsed(false);

		return nf.format(value);
	}

	public double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	};

	public double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	};

}
