package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Articles;

/**
 * 記事情報の操作をするリポジトリ
 * 
 * @author ishida fuya
 */
@Repository
public class BbsRepository {
	
	private static final RowMapper<Articles> ARTICLES_ROW_MAPPER = (rs, i) -> {
		Articles articles = new Articles();
		articles.setId(rs.getInt("id"));
		articles.setName(rs.getString("name"));
		articles.setContent(rs.getString("content"));
		return articles;
	};
	
	/** template */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 記事内容一覧の取得
	 * 
	 * 
	 * @return 記事内容一覧
	 */
	public List<Articles> findAll() {
		String sql= "SELECT id,name,content FROM articles ORDER BY id DESC";
		
		return template.query(sql, ARTICLES_ROW_MAPPER);
	}
	
	/**
	 * 記事の投稿
	 * 
	 * 
	 * 
	 */
	public void insert(Articles articles) {
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(articles);
		String insertsql = "INSERT INTO articles(name,content) VALUES(:name,:content) ";
		template.update(insertsql,param);
		
		
		
		
	}

}
