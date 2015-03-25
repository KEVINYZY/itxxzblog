  
/**  
 * �ļ�����ArticleMapper.java  
 *   
 * ���ڣ�2015��3��19��  
 *  
*/  
    
package com.itxxz.blog.article.mapper;

import org.springframework.stereotype.Repository;

import com.itxxz.blog.article.entity.Article;
import com.itxxz.framework.base.BaseMapper;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��19�� ����8:56:53   
 */
@Repository("articleMapper")
public interface ArticleMapper extends BaseMapper<Article>{

	public Article findByArticleId(int articleId);
}
