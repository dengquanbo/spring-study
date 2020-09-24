package aop;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import cn.dqb.springaop.cglib.CglibProxy;
import cn.dqb.springaop.jdkproxy.JDKInvocationHandler;
import cn.dqb.springaop.service.IGoodService;
import cn.dqb.springaop.service.impl.GoodServiceImpl;

@BenchmarkMode({Mode.AverageTime}) // 吞吐量
@OutputTimeUnit(TimeUnit.NANOSECONDS) // 结果所使用的时间单位
@State(Scope.Benchmark) // 每个测试线程分配一个实例
@Fork(2) // Fork进行的数目
@Warmup(iterations = 1) // 先预热4轮
@Measurement(iterations = 1, time = 2) // 进行10轮测试
public class JdkAndCglibCompare {
    IGoodService jdkProxy;
    IGoodService cglibProxyGoodService;

    @Setup(Level.Trial) // 初始化方法，在全部Benchmark运行之前进行
    public void init() {
        IGoodService goodService = new GoodServiceImpl();
        // 获取代理对象
        JDKInvocationHandler<IGoodService> invocationHandler = new JDKInvocationHandler<>(goodService);
        jdkProxy = invocationHandler.createProxy();


        CglibProxy cglibProxy = new CglibProxy();
        cglibProxyGoodService = cglibProxy.newProxyInstance(GoodServiceImpl.class);
    }

    @Benchmark
    public void test1() {
        jdkProxy.listGood();
    }

    @Benchmark
    public void test2() {
        cglibProxyGoodService.listGood();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JdkAndCglibCompare.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
