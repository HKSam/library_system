package cn.edu.jxnu.base.dao;

import org.springframework.stereotype.Repository;

import cn.edu.jxnu.base.dao.IBaseDao;
import cn.edu.jxnu.base.entity.Role;

/**
 * 角色管理dao
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Integer> {

}
