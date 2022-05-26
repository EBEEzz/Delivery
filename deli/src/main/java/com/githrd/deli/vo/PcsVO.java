package com.githrd.deli.vo;

import java.text.*;
import java.sql.Time;
import java.util.Date;

public class PcsVO {
	private int mno, esti, img;
	private String id, name, kakaoid, pw, mail, tel, addr, sdate, oriname;
	private Date jdate;
	private Time jtime;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getEsti() {
		return esti;
	}
	public void setEsti(int esti) {
		this.esti = esti;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKakaoid() {
		return kakaoid;
	}
	public void setKakaoid(String kakaoid) {
		this.kakaoid = kakaoid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일 ");
		SimpleDateFormat form2 = new SimpleDateFormat("24HH:mm:ss ");
		sdate = form1.format(jdate) + form2.format(jtime);
		
	}
	public Date getJdate() {
		return jdate;
	}
	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}
	public Time getJtime() {
		return jtime;
	}
	public void setJtime(Time jtime) {
		this.jtime = jtime;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	@Override
	public String toString() {
		return "PcsVO [mno=" + mno + ", esti=" + esti + ", img=" + img + ", id=" + id + ", name=" + name + ", kakaoid="
				+ kakaoid + ", pw=" + pw + ", mail=" + mail + ", tel=" + tel + ", addr=" + addr + ", sdate=" + sdate
				+ ", oriname=" + oriname + ", jdate=" + jdate + ", jtime=" + jtime + "]";
	}
	

	
	
	
}
