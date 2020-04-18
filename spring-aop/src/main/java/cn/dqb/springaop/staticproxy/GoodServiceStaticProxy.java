package cn.dqb.springaop.staticproxy;


import cn.dqb.springaop.service.IGoodService;

/**
 * 　代理类，实现了代理接口。
 */
public class GoodServiceStaticProxy implements IGoodService {
    /**
     * 代理类持有一个委托类的对象引用
     */
    private IGoodService goodService;

    public GoodServiceStaticProxy(IGoodService goodService) {
        this.goodService = goodService;
    }

    @Override
    public void listGood() {
        long start = System.currentTimeMillis();
        goodService.listGood();
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format("方法:%s,耗时:%s", "listGood", cost));
    }

    @Override
    public void getGood(Long id) {
        long start = System.currentTimeMillis();
        goodService.getGood(id);
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format("方法:%s,耗时:%s", "getGood", cost));
    }
}
