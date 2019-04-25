package com.testStreamApi;

import com.test.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 终止操作会从流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是void
 *
 * １．查找与匹配
 *
 * allMatch(Predicate p)      检查是否匹配所有元素
 * anyMatch(Predicate p)      检查是否至少匹配一个元素
 * noneMatch(Predicate p)       检查是否没有匹配所有元素
 * findFirst()                返回第一个元素 终端操作会从流的流水线生成结果。其结果可以是任何不是流的 值，例如：List、Integer，甚至是 void 。
 * findAny()              返回当前流中的任意元素
 * count()               返回流中元素总数
 * max(Comparator c)        返回流中最大值
 * min(Comparator c)        返回流中最小值
 * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。 返回 T
 *
 *
 * 2 归约
 * reduce(BinaryOperator b)   可以将流中元素反复结合起来，得到一个值。 返回 Optional<T>
 *                                备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 Google 用它 来进行网络搜索而出名。
 * forEach(Consumer c)         内部迭代(使用 Collection 接口需要用户去做迭 代，称为外部迭代。相反，Stream API 使用内部 迭代——它帮你把迭代做了)
 *
 * 3 收集
 *  collect(Collector c) 将流转换为其他形式。接收一个 Collector接口的  实现，用于给Stream中元素做汇总的方法
 *
 *  Collector 接口中方法的实现决定了如何对流执行收集操作(如收 集到 List、Set、Map)。但是 Collectors 实用类提供了很多静态 方法，可以方便地创建常见收集器实例，
 *
 */
public class TestStreamApi3 {




    List<Employee> employees=Arrays.asList(
            new Employee("张三",18,9999.99,"FREE"),
            new Employee("李四",58,5555.55,"BUSY"),
            new Employee("王五",26,3333.33,"VOCATION"),
            new Employee("赵六",36,6666.66,"FREE"),
            new Employee("田七",12,8888.88,"BUSY")
    );
    /*
     * 查找与匹配
     *
     */

//    @Test
//    public void test1(){
//        boolean b1=employees.stream()//allMatch-检查是否匹配所有元素
//                .allMatch((e)->e.getStatus().equals(Status.BUSY));
//        System.out.println(b1);//false
//
//        boolean b2=employees.stream()//anyMatch-检查是否至少匹配一个元素
//                .anyMatch((e)->e.getStatus().equals(Status.BUSY));
//        System.out.println(b2);//true
//
//        boolean b3=employees.stream()//noneMatch-检查是否没有匹配所有元素
//                .noneMatch((e)->e.getStatus().equals(Status.BUSY));
//        System.out.println(b3);//false
//
//        Optional<Employee> op=employees.stream()//findFirst-返回第一个元素//Optional是Java8中避免空指针异常的容器类
//                .sorted((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()))
//                .findFirst();
//        System.out.println(op.get());//Employee [name=王五, age=26, salary=3333.33, Status=VOCATION]
//
//        Optional<Employee> op2=employees.parallelStream()//findAny-返回当前流中的任意元素
//                .filter((e)->e.getStatus().equals(Status.FREE))
//                .findAny();
//        System.out.println(op2.get());//Employee [name=赵六, age=36, salary=6666.66, Status=FREE]
//
//        Long count=employees.stream()//count-返回流中元素的总个数
//                .count();
//        System.out.println(count);//5
//
//        Optional<Employee> op3=employees.stream()//max-返回流中最大值
//                .max((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary()));
//        System.out.println(op3.get());//Employee [name=张三, age=18, salary=9999.99, Status=FREE]
//
//        Optional<Double> op4=employees.stream()//min-返回流中最小值
//                .map(Employee::getSalary)
//                .min(Double::compare);
//        System.out.println(op4.get());//3333.33
//    }
}
