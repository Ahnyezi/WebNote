package com.example.app2.model.join;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Shop_Member {
	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;

	@Enumerated(EnumType.STRING)
	private MemberType type;

	public Shop_Member() {
	}

	public Shop_Member(String id, String pwd, String name, String email, MemberType type) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Shop_Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", type=" + type
				+ "]";
	}

}
