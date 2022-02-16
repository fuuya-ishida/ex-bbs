package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;


/**
 * コメント情報の操作をするリポジトリ
 * 
 * @author ishida fuya
 */
@Repository
public class CommentRepository {
	
	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		return comment;
	};
	
	/** template */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Comment>findByArticleId(int articleId) {
		String sql = "SELECT id,name,content,article_id FROM comments"
				+ " WHERE article_id = :article_id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("article_id", articleId);
		
		return template.query(sql, param,COMMENT_ROW_MAPPER);
				
	}
	
	/**
	 * コメントの投稿
	 * 
	 * @param comment
	 * @return 
	 */
	public void insert(Comment comment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		String insertsql = "INSERT INTO comments(name,content,article_id)"
				+ " VALUES(:name,:content,:articleId)";
		template.update(insertsql,param);
		
	}
		/**
		 * コメントの削除
		 * @param
		 * @return 
		 * */
		
		public void deleteByArticleId(int articleId) {
			String sql = "DELETE FROM comments WHERE article_id = :article_id";
			
			SqlParameterSource param = new MapSqlParameterSource().addValue("article_id",articleId);
			
			template.update(sql, param);
			
		}
	}



