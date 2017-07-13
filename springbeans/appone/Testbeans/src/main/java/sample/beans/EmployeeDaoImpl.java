package sample.beans;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {

    private JdbcTemplate jt;
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template)
    {
        this.template = template;
    }

    public void setjt(JdbcTemplate  jdbcTemplate)
    {
        this.jt = jdbcTemplate;
    }

    public int saveEmp(int empId, String empName, Double empSal) {

        String sql = "insert into Employee values(?,?,?)";
        int c = jt.update(sql,empId,empName,empSal);
        return c;
    }

    public Employee getEmployeeById(int empId) {
        String sql = "select * from Employee where eid=?";
        EmpRowMapper rowMapper = new EmpRowMapper();
        Employee emp = jt.queryForObject(sql,rowMapper,100);
        return emp;
    }

    public List<Employee> getAllEmployees() {
        String sql = "select * from Employee";
        EmpRowMapper rowMapper = new EmpRowMapper();
        List<Employee> empList= jt.query(sql,rowMapper);
        return empList;
    }

    public int saveEmpHt(Employee e)
    {
        int count = (Integer)template.save(e);
        System.out.println("no of rows effected " + count);
        return count;
    }
    public Employee getEmployeeByIdHt(int empId) {
        Employee emp =(Employee)template.get(Employee.class,empId);
        return emp;
    }

    public List<Employee> getAllEmployeesHt() {
        List<Employee> empList = template.loadAll(Employee.class);
        return empList;
    }

    public void deleteEmployeeByIdHt(Employee emp) {
        template.delete(emp);
    }
}
