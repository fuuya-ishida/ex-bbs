package com.example.form;

import java.util.List;

import com.example.domain.Comment;

public class ArticleForm {
	
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
		return "ArticleForm [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList
				+ "]";
	}

}
