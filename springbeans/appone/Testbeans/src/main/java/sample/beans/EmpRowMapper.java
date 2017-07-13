package sample.beans;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet resultSet, int i)  {
        try {
            Employee emp = new Employee();
            emp.setEmpid(resultSet.getInt("eid"));
            emp.setEmpName(resultSet.getString("ename"));
            emp.setEmpsal(resultSet.getDouble("esal"));
            return emp;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
