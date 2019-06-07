package cn.edu.jxnu.base.dao;

import org.springframework.stereotype.Repository;

import cn.edu.jxnu.base.dao.IBaseDao;
import cn.edu.jxnu.base.entity.Book;

/**
 * 图书管理dao
 *
 */
@Repository
public interface IBookDao extends IBaseDao<Book, String> {

	/**
	 * 根据图书ID查询图书

	 */
	Book findByBookId(String bookId);

	/**
	 * 根据图书名字，查询图书
	 *
	 */
	Book findByBookName(String bookName);

	/**
	 * 根据出版社查询图书
	 *
	 */
	Book findByBookPress(String bookPress);

}
