package cn.dqb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dqb.dao.GoodMapper;
import cn.dqb.entity.Good;
import cn.dqb.service.GoodService;

/**
 * @author baes
 * @date 2018/8/16 11:43
 *
 */
@Service
public class GoodServiceImpl implements GoodService {
	@Autowired
	private GoodMapper goodMapper;

	@Override
	public List<Good> listGood() {
		System.out.println("listGood");
		return goodMapper.listGood();
	}
}
