package com.test;

public class FilterEmpByAge implements MyPredicate<Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >35;
    }
}
