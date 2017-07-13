package sample.beans;


import java.util.List;

public interface IEmployeeDao {


    int saveEmp(int empId,String empName, Double empSal);
    int saveEmpHt(Employee e);
    Employee getEmployeeByIdHt(int empId);
    Employee getEmployeeById(int empId);
    void deleteEmployeeByIdHt(Employee e);
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployeesHt();

}
