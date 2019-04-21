package com.test1;


//过滤器
@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);


}
