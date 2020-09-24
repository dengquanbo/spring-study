package cn.dqb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

import cn.dqb.annotation.SwitchDB;
import cn.dqb.common.DynamicDataSource;
import cn.dqb.entity.Good;
import cn.dqb.mapper.IGoodMapper;
import cn.dqb.service.IGoodService;

/**
 * @author dqb
 * @date 2018/8/16 11:43
 */
@Service
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private IGoodMapper goodMapper;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @SwitchDB(value = DynamicDataSource.dataSource2)
    @Override
    public List<Good> listGood() {
        return goodMapper.listGood();
    }

    @SwitchDB(value = DynamicDataSource.dataSource2)
    @Override
    public boolean addGood(Good good) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        return transactionTemplate.execute(status -> goodMapper.addGood(good) > 0);
    }

    @Transactional
    @Override
    public void addGood(Good good, boolean isSuccess) {
        addGood(good);
    }

}
