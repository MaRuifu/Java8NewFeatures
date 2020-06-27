package com.test;

public class Employee {

    //姓名
    private String name;
    //年龄
    private Integer age;
    //薪水
    private double salary;

    private String statusCode;


    public static final String FREE = "FREE";
    public static final String BUSY = "BUSY";
    public static final String VOCATION = "VOCATION";




    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }



    public Employee() {
    }

    public Employee(String name, Integer age, double salary, String statusCode) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Employee(String name, Integer age, double salary) {

        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
