package cn.dqb.service;

import java.util.List;

import cn.dqb.entity.Good;

/**
 * @author dqb
 * @date 2018/8/16 11:43
 * @description
 */
public interface IGoodService {
	List<Good> listGood();

	boolean addGood(Good good);

	void addGood(Good good, boolean isSuccess);
}
