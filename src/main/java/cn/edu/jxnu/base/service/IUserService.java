package cn.edu.jxnu.base.service;

import cn.edu.jxnu.base.entity.User;

/**
 * 用户服务接口
 *
 */
public interface IUserService extends IBaseService<User, Integer> {

	/**
	 * 根据姓名查询用户

	 */
	User findByUserName(String username);


	User findByUserCode(String userCode);

	/**
	 * 增加或者修改用户
	 */
	void saveOrUpdate(User user);

	/**
	 * 给用户分配角色
	 */
	void grant(Integer id, String[] roleIds);

}
