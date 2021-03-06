package cn.edu.jxnu.base.service;

import cn.edu.jxnu.base.entity.Book;

/**
 * 图书服务接口
 */
public interface IBookService extends IBaseService<Book, String> {

	/**
	 * 根据图书id查找图书
	 * 
	 * @param id
	 * @return Book
	 */
	Book findByBookId(String id);

	/**
	 * 根据书名查图书
	 * 
	 * @param bookName
	 * @return Book
	 */
	Book findByBookName(String bookName);

	/**
	 * 根据出版社查图书
	 * 
	 * @param bookPress
	 * @return Book
	 */
	Book findByBookPress(String bookPress);

	/**
	 * 保存或更新图书信息
	 * 
	 * @param book
	 * @return void
	 */
	void saveOrUpdate(Book book);

	/**
	 * 保存或更新图书信息
	 * 携带当前库存

	 * @param book
	 * @param cInventory
	 */
	void saveOrUpdate(Book book, Integer cInventory);

}
