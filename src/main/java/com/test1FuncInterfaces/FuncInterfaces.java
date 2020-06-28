package com.test1FuncInterfaces;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * Java8的内置四大核心函数式接口
 * Consumer<T> :消费型接口
 *         void accept(T t);
 *  Supplier<T>:供给型接口
 *          T get();
 *   Function<T ,R> :函数型接口
 *      R apply(T t);
 *  Predicate<T> :断言型接口
 *      boolean test(T t);
 *
 */


public class FuncInterfaces {

    @Test
    public void test1(){

        accept(100,x-> System.out.println("小名花了:"+x +"元买了一个足球"));
    }

    public void accept(Integer i,Consumer<Integer> con){
       con.accept(i);
    }


    //需求 产生制定个数的整数,并放入集合
    @Test
    public void test2(){

        List<Integer> numList = getNumList(10,() -> (int)(Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);

        }
    }


    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num ; i++) {
            list.add(supplier.get());
        }
        return  list;
    }



    @Test
    public void test3(){


        String newStr = strHandler("qwewertasd" , x -> x.toUpperCase());
        System.out.println(newStr);
    }


    public String  strHandler(String str, Function<String , String > fun){

        return  fun.apply(str);
    }




    @Test
    public void test4(){


        boolean result = getPredicate(100, x -> x > 500);
        System.out.println(result);
    }




    public boolean  getPredicate(Integer moner, Predicate<Integer > predicate){

        return  predicate.test(moner);
    }

}
