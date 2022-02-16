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

@Controller
@RequestMapping("/ExBbs")
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
	
	@Autowired
	private CommentService commentService;
	
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String Bbs() {
		
		List<Article> articleList = bbsService.findAll();
		
		for(Article article:articleList) {

			article.setCommentList(commentService.findByArticleId(article.getId()));
			
		}
		
		session.setAttribute("articleList", articleList);
		return "/bbs";
	}
	
	@RequestMapping("/post")
	public String insertArticle(String name,String content,Article article) {
		article.setName(name);
		article.setContent(content);
		bbsService.insert(article);
		session.setAttribute("articleList", bbsService.findAll());
		return "/bbs";
	}
	
	

}
