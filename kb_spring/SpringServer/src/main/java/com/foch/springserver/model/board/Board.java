package com.foch.springserver.model.board;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Board")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "letter_num", nullable = false)
	private int letterNum;
	
	@Column(name = "user_id", length = 50, nullable = false)
	private String userId;
	
	@Column(name = "title", length = 50, nullable = false)
	private String title;
	
	@Column(name = "content", length = 100, nullable = false)
	private String content;
	
	@Column(name = "content2", length = 100, nullable = false)
	private String content2;
	
	@Column(name = "written_dt", nullable = false)
	private Timestamp writtenDt;

	public int getLetterNum() {
		return letterNum;
	}

	public void setLetterNum(int letterNum) {
		this.letterNum = letterNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public Timestamp getWrittenDt() {
		return writtenDt;
	}

	public void setWrittenDt(Timestamp writtenDt) {
		this.writtenDt = writtenDt;
	}
	
}
