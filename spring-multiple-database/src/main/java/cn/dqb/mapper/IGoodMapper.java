package cn.dqb.mapper;

import java.util.List;

import cn.dqb.entity.Good;

/**
 * @author dqb
 */
public interface IGoodMapper {
    List<Good> listGood();

    int addGood(Good good);
}
