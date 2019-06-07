package cn.edu.jxnu.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.jxnu.base.dao.IBaseDao;
import cn.edu.jxnu.base.dao.IMemorandumDao;
import cn.edu.jxnu.base.entity.Memorandum;
import cn.edu.jxnu.base.service.IMemorandumService;



@Service
public class MemorandumServiceImpl extends BaseServiceImpl<Memorandum, Integer> implements IMemorandumService {

	@Autowired
	private IMemorandumDao memorandumDao;

	public Memorandum find(String id) {
		return null;
	}

	@Override
	public IBaseDao<Memorandum, Integer> getBaseDao() {
		return this.memorandumDao;
	}

}
