package com.test6defFunc;


/**
 * 以前接口类中只允许有全局静态常量和抽象方法
 *
 * 1、Java8中允许接口中包含具有具体实现的方法，该方法称为“默认方法”，默认方法使用 default 关键字修饰。
 *
 * 接口默认方法的“类优先”原则：
 *
 * 若一个接口中定义了一个默认方法，而另一个父类或接口中又定义了一个同名的方法时
 *
 * 选择父类中的方法。如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略。
 * 接口冲突。如果一个父接口提供一个默认方法，而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），那么必须覆盖该方法来解决冲突。
 * 2、Java8 中，接口中允许添加静态方法。
 */
public interface TestDefFunc {

    interface MyFunc{
        default String getName(){
            return "hahaha";
        }
    }

    interface Named{
        default String getName(){
            return "hehehe";
        }
    }

    class MyClass implements MyFunc,Named{
        public String getName(){
            return Named.super.getName();
        }
    }
}
