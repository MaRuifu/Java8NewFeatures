package com.test1;

public class FilterEmpByAge implements MyPredicate <Employee> {


    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >35;
    }
}
