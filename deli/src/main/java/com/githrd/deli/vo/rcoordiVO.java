package com.githrd.deli.vo;

public class rcoordiVO {
	private int resno,cate_no;
	private String resname,category;
	private double reslat, reslon, mylat, mylon, resdist;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCate_no() {
		return cate_no;
	}
	public void setCate_no(int cate_no) {
		this.cate_no = cate_no;
	}
	public int getResno() {
		return resno;
	}
	public void setResno(int resno) {
		this.resno = resno;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public double getReslat() {
		return reslat;
	}
	public void setReslat(double reslat) {
		this.reslat = reslat;
	}
	public double getReslon() {
		return reslon;
	}
	public void setReslon(double reslon) {
		this.reslon = reslon;
	}
	public double getMylat() {
		return mylat;
	}
	public void setMylat(double mylat) {
		this.mylat = mylat;
	}
	public double getMylon() {
		return mylon;
	}
	public void setMylon(double mylon) {
		this.mylon = mylon;
	}
	public double getResdist() {
		return resdist;
	}
	public void setResdist(double resdist) {
		this.resdist = resdist;
	}
	@Override
	public String toString() {
		return "rcoordiVO [resno=" + resno + ", resname=" + resname + ", category=" + category + ", reslat=" + reslat
				+ ", reslon=" + reslon + ", mylat=" + mylat + ", mylon=" + mylon + ", resdist=" + resdist + ", cate_no="
				+ cate_no + "]";
	}
	
	
	
	
	
	
}
