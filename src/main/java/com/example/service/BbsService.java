package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.BbsRepository;

@Service
@Transactional
public class BbsService {

	@Autowired
	private BbsRepository bbsRepository;

	public List<Article> findAll() {
		return bbsRepository.findAll();
	}
	
	public void insert(Article article) {
		bbsRepository.insert(article);
	}
	
	public void deleteById(int id) {
		bbsRepository.deleteById(id);
	}
}
