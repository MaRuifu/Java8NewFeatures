package com.test1;

import org.junit.Test;

import java.util.*;

public class TestLambda {


    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return  Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);

    }


    List<Employee>  empList = Arrays.asList(
            new Employee("张三",28,5555.55),
            new Employee("李四",38,5888.55),
            new Employee("王五",18,5555.55),
            new Employee("赵六",58,6666.55),
            new Employee("孙七",22,2222.55),
            new Employee("周八",45,3333.55)

    );

    @Test
    public void test3(){
        for (Employee employee : filterEmp(empList)) {
            System.out.println(employee);
        }
    }

    //获取当前公司中年龄大于35的员工
    public List<Employee> filterEmp(List<Employee> list) {
        List<Employee>  empList = new ArrayList<>();
        for (Employee employee : list) {
            if(employee.getAge()> 35){
                empList.add(employee);
            }
        }
        return empList;
    }



    //获取当前公司中工资大于3500的员工
    public List<Employee> filterEmp2(List<Employee> list) {
        List<Employee>  empList = new ArrayList<>();
        for (Employee employee : list) {
            if(employee.getSalary()> 3500){
                empList.add(employee);
            }
        }
        return empList;
    }



    //优化方式一  设计模式  --策略模式

     public List<Employee> filterEmp(List<Employee> list ,MyPredicate<Employee> mp){

         List<Employee> empList = new ArrayList<>();

         for (Employee employee : list) {
             if(mp.test(employee)){
                 empList.add(employee);
             }
         }
        return empList;
     }


    @Test
    public void test4(){
        for (Employee employee : filterEmp(empList,new FilterEmpBySalary())) {
            System.out.println(employee);
        }
        System.out.println("_______________________________________________");
        for (Employee employee1 : filterEmp(empList,new FilterEmpByAge())) {
            System.out.println(employee1);
        }

    }


    //优化方式二  匿名内部类

    @Test
    public void test5(){

        List<Employee> list = filterEmp(empList,new MyPredicate<Employee>(){

            @Override
            public boolean test(Employee employee) {

                return employee.getAge() > 35;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }

    }



    //优化方式三  lambda 表达式

    @Test
    public void test6(){

        List<Employee> list = filterEmp(empList ,(x)-> x.getSalary() >= 3500);
        list.forEach(System.out::println);

    }


    //优化方式四  Stream API

    @Test
    public void test7(){
        empList.stream().filter(x -> x.getSalary() > 3500).forEach(System.out::println);
    }


}
