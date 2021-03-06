package com.elvis.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "springdb")

public class News implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", pubdate=" + pubdate + ", content=" + content + "]";
	}

	private Integer nid;
	private String title;
	private Date pubdate;
	private String content;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String title, Date pubdate, String content) {
		this.title = title;
		this.pubdate = pubdate;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "nid", unique = true, nullable = false)

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	@Column(name = "title", length = 50)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pubdate", length = 10)

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Column(name = "content", length = 65535)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}