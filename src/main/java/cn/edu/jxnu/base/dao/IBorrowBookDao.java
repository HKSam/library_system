package cn.edu.jxnu.base.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.edu.jxnu.base.dao.IBaseDao;
import cn.edu.jxnu.base.entity.BorrowBook;

/**
 * 借书管理dao
 */
@Repository
public interface IBorrowBookDao extends IBaseDao<BorrowBook, String> {
	/**
	 * 根据用户查询借阅列表

	 */
	BorrowBook[] findByUserId(int userId);

	/**
	 * 根据图书查询借阅列表
	 */
	BorrowBook[] findByBookId(String bookId);

	/**
	 * 根据用户ID和图书ID查询唯一一条借书记录

	 */
	BorrowBook findByUserIdAndBookId(int userId, String bookId);

	/**
	 * 事务删除或修改操作，不支持新增/插入
	 */
	@Modifying
	@Query("DELETE FROM BorrowBook b WHERE b.userId = ?1 and b.bookId= ?2")
	void mDelet(int userId, String bookId);

}
