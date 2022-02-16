package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Articles;
import com.example.service.BbsService;

@Controller
@RequestMapping("/ExBbs")
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String Bbs() {
		
		
		session.setAttribute("articleList", bbsService.findAll());
		
		return "/bbs";
	}
	
	@RequestMapping("/post")
	public String insertArticle(String name,String content,Articles articles) {
		articles.setName(name);
		articles.setContent(content);
		bbsService.insert(articles);
		session.setAttribute("articleList", bbsService.findAll());
		return "/bbs";
	}
	
	

}
