package cn.edu.jxnu.base.service;

import cn.edu.jxnu.base.entity.Role;

/**
 * 角色服务接口
 *
 */
public interface IRoleService extends IBaseService<Role, Integer> {

	/**
	 * 添加或者修改角色
	 */
	void saveOrUpdate(Role role);

	/**
	 * 给角色分配资源
	 */
	void grant(Integer id, String[] resourceIds);

}
