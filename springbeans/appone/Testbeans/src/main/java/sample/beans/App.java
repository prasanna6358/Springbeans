package sample.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object pobj = context.getBean("empDao");
        IEmployeeDao e = (IEmployeeDao) pobj;
        //int c = e.saveEmp(107,"siryali",12010.00);
        //System.out.println(c);
        Employee emp = e.getEmployeeById(100);
        System.out.println(emp);
        System.out.println();
        Employee empht = e.getEmployeeByIdHt(111);
        System.out.println(empht);
        Employee e1 = new Employee();
        e1.setEmpid(114);
        e.deleteEmployeeByIdHt(e1);
        List<Employee> emplist = e.getAllEmployeesHt();
        for(Employee employee:emplist)
        {
            System.out.println(employee);
        }
        System.out.println("*****************************");
        System.out.println();
    }
}
