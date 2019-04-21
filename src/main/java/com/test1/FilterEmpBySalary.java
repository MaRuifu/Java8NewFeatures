package com.test1;

public class FilterEmpBySalary implements MyPredicate <Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >5000;
    }
}
