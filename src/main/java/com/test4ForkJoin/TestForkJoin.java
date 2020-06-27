package com.test4ForkJoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    @Test
    public void test1(){
        Instant start=Instant.now();

        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinCalculate(0L, 10000000000L);
        long sum=pool.invoke(task);
        System.out.println(sum);

        Instant end=Instant.now();
        System.out.println("消耗时间"+ Duration.between(start, end).toMillis()+"ms");//消耗时间3409ms
    }

    @Test//直接使用java8的并行流
    public void test2(){
        Instant start=Instant.now();

        Long sum= LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .reduce(0,Long::sum);
        System.out.println(sum);

        Instant end=Instant.now();
        System.out.println("消耗时间"+Duration.between(start, end).toMillis()+"ms");//消耗时间2418ms
    }
}