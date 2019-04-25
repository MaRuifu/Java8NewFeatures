package com.testStreamApi;


import com.test.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建Stream
 * 1.可以通过Collection 系列集合提供的stream()或parallelStream()方法
 *
 * default Stream< E> stream() : 返回一个顺序流
 * default Stream< E> parallelStream() : 返回一个并行流
 * 2.通过 Arrays 中的静态方法stream()获取数组流
 *
 * static < T> Stream< T> stream(T[] array): 返回一个流
 *
 * 重载形式，能够处理对应基本类型的数组：
 *
 * public static IntStream stream(int[] array)
 * public static LongStream stream(long[] array)
 * public static DoubleStream stream(double[] array)
 * 3.通过Stream 类中的静态方法of()，通过显示值创建一个流。它可以接收任意数量的参数。
 *
 * public static< T> Stream< T> of(T… values) : 返回一个流
 * 4.创建无限流
 * 可以使用静态方法 Stream.iterate() 和Stream.generate(), 创建无限流。
 *
 * 迭代
 * public static< T> Stream< T> iterate(final T seed, final UnaryOperator< T> f)
 * 生成
 * public static< T> Stream< T> generate(Supplier< T> s)
 */
public class TestStreamApi1 {

    //创建Stream
    @Test
    public void test1(){
        //1.可以通过Collection 系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过 Arrays 中的静态方法stream()获取数组流
        Employee[] emps=new Employee[10];
        Stream<Employee> stream2= Arrays.stream(emps);

        //3.通过Stream 类中的静态方法of()
        Stream<String> stream3=Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4=Stream.iterate(0, (x) -> x+2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

}
