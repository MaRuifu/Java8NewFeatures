package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class TestDemo {


    public static void main(String[] args) {
        String str = "101,lisi,98;202,wangwu,76;303,chenqi,84;404,zhangsan,49;505,xiaoming,67";
        List<Student> stuList =  Arrays.stream(str.split(";"))
                .map(stu-> stu.split(","))
                .map(strA ->new Student(strA[0],strA[1],strA[2]) )
                .filter(stu -> "xiaoming".equals(stu.getName()))
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.toList());
        stuList.forEach(System.out::println);

    }




    static class Student{

        private String id;
        private String  name;
        private String  score;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }


        public Student(String id, String name, String score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public Student() {
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", score='" + score + '\'' +
                    '}';
        }
    }






}
