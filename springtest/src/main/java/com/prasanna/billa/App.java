package com.prasanna.billa;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student  =(Student)context.getBean("studentbean");
        Address address  =(Address) context.getBean("addressBean");
        System.out.println(address.getLocation());
        student.displayInfo();
        System.out.println(student.toString());
        List<Courses> courses = student.getCourses();
        courses.forEach(courses1 -> System.out.println(courses1.getCourseId()+" "+courses1.getCourseName()));
    }
}
