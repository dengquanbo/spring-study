package cn.dqb.springaop.service.impl;

import cn.dqb.springaop.service.IGoodService;

public class GoodServiceImpl implements IGoodService {
    @Override
    public void listGood() {
        int i = 0;
        while (i < 1000) {
            i++;
        }
    }

    @Override
    public void getGood(Long id) {

    }

    private void getGood1(Long id) {

    }

    protected void getGood2(Long id) {

    }

    void getGood3(Long id) {

    }

    public final void getGood4(Long id) {

    }

    public static void getGood5(Long id) {

    }
}
