package cn.edu.jxnu.base.service;

import java.util.List;

import cn.edu.jxnu.base.entity.Resource;
import cn.edu.jxnu.base.entity.ZtreeView;

/**
 * 资源服务接口
 *
 */
public interface IResourceService extends IBaseService<Resource, Integer> {

	/**
	 * 获取角色的权限树
	 * 
	 * @param roleId
	 * @return List<ZtreeView>
	 */
	List<ZtreeView> tree(int roleId);

	/**
	 * 修改或者新增资源
	 * 
	 * @param resource
	 */
	void saveOrUpdate(Resource resource);

	/**
	 * 根据id查询资源
	 *
	 */
	Resource find(Integer integer);

}
