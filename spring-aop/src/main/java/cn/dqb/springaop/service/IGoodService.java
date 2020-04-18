package cn.dqb.springaop.service;

public interface IGoodService {
    /**
     * 查询商品列表
     */
    void listGood();

    /**
     * 获得商品详情
     */
    void getGood(Long id);
}
