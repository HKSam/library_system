package cn.edu.jxnu.base.dao;

import org.springframework.stereotype.Repository;

import cn.edu.jxnu.base.dao.IBaseDao;
import cn.edu.jxnu.base.entity.User;

/**
 * 用户管理dao

 */
@Repository
public interface IUserDao extends IBaseDao<User, Integer> {

	/**
	 * 根据姓名查询用户

	 */
	User findByUserName(String username);

	/**
	 * 根据账号查询用户

	 */
	User findByUserCode(String usercode);

}
