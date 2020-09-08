package com.example.app3.model.article;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

import com.example.app3.model.join.Usertb;

@Entity
public class Article {
	@Id
	//자동 넘버링 타입: oracle은 시퀀스로 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="article_sequence")
	//시퀀스 생성
	@SequenceGenerator(name="article_sequence",sequenceName="seq_article")
	private int num;//글 번호 자동으로 넣어줄 경우 시퀀스 필요
	
	@ManyToOne//Usertb클래스와 다:1의 관계를 갖도록함
	@JoinColumn(name="writer",nullable=false)//name: writer를 조인, nullable: usertb에 없는 아이디는 글 작성 불가능하게
	private Usertb writer;//foreign key로 만들어주기 위해[article이 자식, usertb이 부모가 되도록 설정]
	
	private String title;
	private Date w_date;
	private String content;
	
	@PrePersist
	//쿼리 실행 전 실행: 쿼리문을 직접 작성해서 sysdate 쓰는 것이 아니기 때문에.
	//날짜를 생성해서 보낸다.
	public void beforeCreate(){
		w_date = new Date();
	}
	
	public Article() {
	}
	public Article(int num, Usertb writer, String title, Date w_date, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.w_date = w_date;
		this.content = content;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Usertb getWriter() {
		return writer;
	}

	public void setWriter(Usertb writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [num=" + num + ", writer=" + writer + ", title=" + title + ", w_date=" + w_date + ", content="
				+ content + "]";
	}
}
