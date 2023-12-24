package org.example.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 성적이낮은순서로학생출력하기 {
    public static class Student implements Comparable<Student>{
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student s) {
            return this.age - s.age; //나(객체)를 앞에둬야 오름차순
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Student> studentList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            studentList.add(new Student(scanner.next(), scanner.nextInt()));
        }

        studentList.sort(Student::compareTo);
        for(Student s : studentList) {
            System.out.print(s.name + " ");
        }
    }
}
//2
//홍길동 95
//이순신 77