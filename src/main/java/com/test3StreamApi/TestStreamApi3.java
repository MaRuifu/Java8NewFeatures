package com.test3StreamApi;

import com.test.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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


    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, "FREE"),
            new Employee("李四", 58, 5555.55, "BUSY"),
            new Employee("王五", 26, 3333.33, "VOCATION"),
            new Employee("赵六", 36, 6666.66, "FREE"),
            new Employee("田七", 12, 8888.88, "BUSY")
    );
    /*
     * 查找与匹配
     *
     */

    @Test
    public void test1() {




        /*
         * 查找与匹配
         *
         */

        boolean b1 = employees.parallelStream()//allMatch-检查是否匹配所有元素
                .allMatch((e) -> e.getStatusCode().equals(Employee.BUSY));
        System.out.println(b1);//false

        boolean b2 = employees.stream()//anyMatch-检查是否至少匹配一个元素
                .anyMatch((e) -> e.getStatusCode().equals(Employee.BUSY));
        System.out.println(b2);//true

        boolean b3 = employees.stream()//noneMatch-检查是否没有匹配所有元素
                .noneMatch((e) -> e.getStatusCode().equals(Employee.BUSY));
        System.out.println(b3);//false

        Optional<Employee> op = employees.stream()//findFirst-返回第一个元素//Optional是Java8中避免空指针异常的容器类
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());//Employee [name=王五, age=26, salary=3333.33, Status=VOCATION]

        Optional<Employee> op2 = employees.parallelStream()//findAny-返回当前流中的任意元素
                .filter((e) -> e.getStatusCode().equals(Employee.FREE))
                .findAny();
        System.out.println(op2.get());//Employee [name=赵六, age=36, salary=6666.66, Status=FREE]

        Long count = employees.stream()//count-返回流中元素的总个数
                .count();
        System.out.println(count);//5

        Optional<Employee> op3 = employees.stream()//max-返回流中最大值
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op3.get());//Employee [name=张三, age=18, salary=9999.99, Status=FREE]

        Optional<Double> op4 = employees.stream()//min-返回流中最小值
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op4.get());//3333.33
    }


    /*
     * 归约
     * reduce(T identity,BinaryOperator b) / reduce(BinaryOperator b)-可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test3(){
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum=list.stream()//reduce(T identity,BinaryOperator b)
                .reduce(0, (x,y)->x+y);//0为起始值
        System.out.println(sum);

        System.out.println("--------------------------");

        Optional<Double> op=employees.stream()//reduce(BinaryOperator b)//没有起始值，map返回可能为空，所以返回Optional类型
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }



    /*
     * 收集
     * collect-将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法。
     */
    @Test
    public void test4(){
        List<String> list=employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("----------------------------");

        Set<String> set=employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("----------------------------");

        HashSet<String> hs=employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);

        System.out.println("----------------------------");

        //总和
        Long count=employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        //平均值
        Double avg=employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        //总和
        Double sum=employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //最大值
        Optional<Employee> max=employees.stream()
                .collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min=employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

        System.out.println("----------------------------");

        //分组
        Map<String,List<Employee>> map=employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatusCode));
        System.out.println(map);//{FREE=[Employee [name=张三, age=18, salary=9999.99, Status=FREE], Employee [name=赵六, age=36, salary=6666.66, Status=FREE]], VOCATION=[Employee [name=王五, age=26, salary=3333.33, Status=VOCATION]], BUSY=[Employee [name=李四, age=58, salary=5555.55, Status=BUSY], Employee [name=田七, age=12, salary=8888.88, Status=BUSY]]}

        //多级分组
        Map<String,Map<String,List<Employee>>> map2=employees.stream()
                .collect( Collectors.groupingBy( Employee::getStatusCode,Collectors.groupingBy((e)->{
                    if(e.getAge()<=35){
                        return "青年";
                    }else if(e.getAge()<=50){
                        return "中年";
                    }else{
                        return "老年";
                    }
                }) ) );
        System.out.println(map2);//{FREE={青年=[Employee [name=张三, age=18, salary=9999.99, Status=FREE]], 中年=[Employee [name=赵六, age=36, salary=6666.66, Status=FREE]]}, VOCATION={青年=[Employee [name=王五, age=26, salary=3333.33, Status=VOCATION]]}, BUSY={青年=[Employee [name=田七, age=12, salary=8888.88, Status=BUSY]], 老年=[Employee [name=李四, age=58, salary=5555.55, Status=BUSY]]}}

        //分区
        Map<Boolean,List<Employee>> map3=employees.stream()
                .collect(Collectors.partitioningBy((e)->e.getSalary()>8000));
        System.out.println(map3);//{false=[Employee [name=李四, age=58, salary=5555.55, Status=BUSY], Employee [name=王五, age=26, salary=3333.33, Status=VOCATION], Employee [name=赵六, age=36, salary=6666.66, Status=FREE]], true=[Employee [name=张三, age=18, salary=9999.99, Status=FREE], Employee [name=田七, age=12, salary=8888.88, Status=BUSY]]}

        System.out.println("--------------------------------");

        DoubleSummaryStatistics dss=employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());

        System.out.println("--------------------------------");
        String strr=employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(strr);//张三李四王五赵六田七
    }
}
