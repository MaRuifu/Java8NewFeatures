package com.test2;

import com.test1.Employee;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一, Lambda 表达式的基础语法: Java8中引入了一个新的操作符  "->" 该操作符称为箭头操作符或 Lamebda操作符
 *                            箭头操作符将 Lambda表达式拆分成两部分
 *
 * 左侧:Lambda表达式的参数列表
 * 右侧:Lambda表达式中所需要执行的功能.即 Lamebda 体
 *
 * 语法格式一 :无参数,无返回值
 *       ( ) -> System.out.println("我是一个无参数无返回值的方法  Lambda");
 *
 * 语法格式二 :有一个参数,并且无返回值
 *       ( x ) -> System.out.println(x.length()
 *
 * 语法格式三 :有一个参数,,小括号可以省略
 *        x  -> System.out.println(x.length()
 *
 *  语法格式四 :有两个以上参数,有返回值,并且 Lambda体 有多条语句
 *            Comparator<Integer> com = (x,y) -> {
 *               System.out.println("打印我一下");
 *               return Integer.compare(x,y);
 *             };
 *
 *  语法格式五 :若 Lambda体中只有一条语句 ,return 和 大括号 都可以省略不写
 *               Comparator<String> com = (x,y) -> Integer.compare(x,y);
 *
 *  语法格式六 : Lambda表达式的参数列表的数据类型可以省略不写,因为JVM 编译器 通过 上下文推断出数据类型  即 "类型推断"
 *
 *              (Integer x,Integer y) -> Integer.compare(x,y)
 *
 * 左右遇一括号省  return
 * 左侧推断类型省
 *
 * 能省则省
 *
 * 二 , Lambda 表达式 需要函数式接口的支持
 *
 * 函数式接口: 接口中只有一个抽象方法的接口,称为函数式接口.可以使用注解 @FunctionalInterface  可以检查是不是函数式接口.
 */


public class TestLambda1 {



    @Test
   public void test1(){
       int num = 0;

       Runnable r = new Runnable() {
           @Override
           public void run() {
               System.out.println("我是一个无参数无返回值的方法" + num);
           }
       };

       r.run();

        System.out.println("*********************************");


        Runnable r1 = ( ) -> System.out.println("我是一个无参数无返回值的方法  Lambda");

        r1.run();
   }



    @Test
    public void test2(){
        Consumer<String> com = (x) -> System.out.println(x.length());
        com.accept("奥术大师大所");
        Consumer<String> com1 = x -> System.out.println(x.length());
        com1.accept("奥术大师大所");
    }



    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("打印我一下");
            return Integer.compare(x,y);
        };


        System.out.println(com.compare(3,2));
    }


    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) ->Integer.compare(x,y);
        System.out.println(com.compare(3,2));
    }


    @Test
    public void test5(){
        String[] strs   = {"aaa","bbb","ccc","ddd"};
//         strs   = {"aaa","bbb","ccc","ddd"};

        List<String>  strList = new ArrayList<>();

        show(new HashMap<>());    // JDK 1.7  通过不了的 必须是 final

    }

    public  void show(Map<String , Integer> map) {

    }


    /**
     * 需求 对一个数进行运算
     */

    @Test
    public void test6(){

        Integer o =operation( 10 ,x -> x*x) ;
        System.out.println(o);

    }

    public  Integer operation(Integer a, MyFun myFun){
        return myFun.oper(a);
    }




}
