package com.example.domain;

import java.util.List;

/**
 * 記事情報を表すドメイン
 * 
 * @author ishida fuya
 */
public class Articles {

	/** ID */
	private Integer id;

	/** 名前 */
	private String name;

	/** 記事内容 */
	private String content;

	/** コメントリスト */
	private List<Comment> commentList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;

	}

	@Override
	public String toString() {
		return "Articles [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList + "]";
	}
}
