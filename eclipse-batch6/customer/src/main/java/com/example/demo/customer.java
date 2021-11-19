package com.example.demo;
import javax.persistence.Entity;

import javax.persistence.Id;
@Entity
public class customer {

	private int cid;
	private String cname;
	private String cphno;
	private String cusername;
	private String cpassword;
	private String cemail;
	@Id
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCphno() {
		return cphno;
	}
	public void setCphno(String cphno) {
		this.cphno = cphno;
	}
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
}
