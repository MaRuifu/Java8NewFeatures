package com.testMethodRef;

import com.test.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一 方法引用: 若 Lambda 体中的内容有方法实现了,我们可以使用"方法引用"
 *            可以理解为方法引用是Lambda表达式的另外一种形式
 *
 *
 *       ### 方法引用三种语法 ###
 *
 *       - 对象::实例方法名
 *
 *       - 类::静态方法名
 *
 *       - 类::实例方法名
 *
 *       注意:
 *       ①Lamebda 体中 调用方法的参数列表与返回值得类型,要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 *       ①若 Lamebda参数列表的第一个参数是实例方法的调用者,而第二个参数是实例方法的参数时,可以使用ClassName :: Methd
 *
 *  二 构造器引用
 *
 *  格式:
 *
 *  ClassName:new
 *
 *  注意:需啊哟平调用的构造器的参数列表与函数式接口中抽象方法的参数列表保持一致!
 *
 *  三 数组引用
 *
 *  格式:
 *
 *  Type[]:new
 *
 *  注意:需啊哟平调用的构造器的参数列表与函数式接口中抽象方法的参数列表保持一致!
 *
 */

public class TestMethodRef {


    //对象::方法名
    @Test
    public void test1(){
        PrintStream ps1 = System.out;

        Consumer<String>  con = x -> ps1.println(x);


        Consumer<String>  con1 = ps1::println;

        Consumer<String>  con2 = System.out::println;

        con2.accept("123");


    }

    @Test
    public void test2(){

        Employee emp = new Employee();

        Supplier<String> sup = () -> emp.getName()  ;

        String str = sup.get();
        System.out.println(str);



        Supplier<Integer> sup1 = emp::getAge  ;

        Integer age = sup1.get();
        System.out.println(age);



    }



    //类::静态方法名
    @Test
    public void test3(){

        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;


    }



    //类::实例方法名
    @Test
    public void tes4(){

        BiPredicate<String,String> com = (x, y)-> x.equals(y);
        BiPredicate<String,String> com1 = String::equals;


    }



    //构造器引用
    @Test
    public void tes5(){


        Supplier<Employee>  sup = ()-> new Employee();

        //构造器引用
        Supplier<Employee>  sup1 = Employee::new;
    }


    //数组引用
    @Test
    public void tes6(){

        Function<Integer,String[]>  fun = (x)-> new String[x];

        Function<Integer,String[]>  fun1 =  String[]::new ;

    }
}
