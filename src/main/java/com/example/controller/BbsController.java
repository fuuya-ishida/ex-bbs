package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.service.BbsService;
import com.example.service.CommentService;

/**
 * 掲示板情報を操作するコントローラー
 * 
 * @author ishida fuya
 *
 */
@Controller
@RequestMapping("/ExBbs")
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
	
	@Autowired
	private CommentService commentService;
	
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 記事情報一覧の取得
	 * 
	 * @param 
	 * @return 記事情報一覧
	 */
	@RequestMapping("")
	public String Bbs() {
		
		List<Article> articleList = bbsService.findAll();
		
		for(Article article:articleList) {

			article.setCommentList(commentService.findByArticleId(article.getId()));
			
		}
		
		session.setAttribute("articleList", articleList);
		return "/bbs";
	}
	
	/**
	 * 記事の投稿
	 * 
	 * @param name,comment
	 * @return 
	 */
	@RequestMapping("/post")
	public String insertArticle(String name,String content,Article article) {
		article.setName(name);
		article.setContent(content);
		bbsService.insert(article);
		session.setAttribute("articleList", bbsService.findAll());
		return "/bbs";
	}
	
	/**
	 * コメントの投稿
	 * 
	 * @param comenterName,comment
	 * @return 
	 * */
	@RequestMapping("/comment")
	public String insertComment(String comenterName,String content,Integer id,Comment comment) {
		comment.setName(comenterName);
		comment.setContent(content);
		comment.setArticleId(id);
		commentService.insert(comment);
		return "forward:/ExBbs";
	}
	
	/**
	 * コメント・記事の削除
	 * @param
	 * @return 
	 * */
	@RequestMapping("/delete")
	public String deleteArticle(int id) {
		commentService.deleteByArticleId(id);
		bbsService.deleteById(id);
		
		
		return "forward:/ExBbs";
	}
	

}
