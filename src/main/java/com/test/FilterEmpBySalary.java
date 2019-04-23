package com.test;

public class FilterEmpBySalary implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >5000;
    }
}
