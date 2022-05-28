package com.githrd.deli.vo;

public class EunbeeVO {
	private int bno, ano, cpts;
	private double esti, point, spts;
	private String id, idb, mail, pw, dir, savename;
	
	public int getBno() {
		return bno;
	}
	
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getEsti() {
		return esti;
	}
	
	public void setEsti(double esti) {
		this.esti = esti;
	}
	
	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdb() {
		return idb;
	}

	public void setIdb(String idb) {
		this.idb = idb;
	}

	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getSavename() {
		return savename;
	}
	
	public void setSavename(String savename) {
		this.savename = savename;
	}

	public int getCpts() {
		return cpts;
	}

	public void setCpts(int cpts) {
		this.cpts = cpts;
	}

	public double getSpts() {
		return spts;
	}

	public void setSpts(double spts) {
		this.spts = spts;
	}

	@Override
	public String toString() {
		return "EunbeeVO [bno=" + bno + ", ano=" + ano + ", cpts=" + cpts + ", esti=" + esti + ", point=" + point
				+ ", spts=" + spts + ", id=" + id + ", idb=" + idb + ", mail=" + mail + ", pw=" + pw + ", dir=" + dir
				+ ", savename=" + savename + "]";
	}


}
