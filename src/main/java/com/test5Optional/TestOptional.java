package com.test5Optional;

import org.junit.Test;

import java.util.Optional;


/**
 * Optional.of(T t) : 创建一个 Optional 实例
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * isPresent() : 判断是否包含值
 * orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
 * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */

public class TestOptional {


    @Test
    public void test5(){
        Man man=new Man();
        String name=getGodnessName(man);
        System.out.println(name);
    }
    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man){
        if(man!=null){
            Godness g=man.getGodness();
            if(g!=null){
                return g.getName();
            }
        }
        return "苍老师";
    }

    //运用Optional的实体类
    @Test
    public void test6(){
        Optional<Godness> godness=Optional.ofNullable(new Godness("林志玲"));
        Optional<NewMan> op=Optional.ofNullable(new NewMan(godness));
        String name=getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }
}
