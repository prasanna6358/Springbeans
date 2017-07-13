package sample.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{


    public Employee() {
    }

    @Id
    @Column(name="eid")
    private int empid;
    @Column(name="ename")
    private String empName;
    @Column(name="esal")
    private Double empsal;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpsal() {
        return empsal;
    }

    public void setEmpsal(Double empsal) {
        this.empsal = empsal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getEmpid() != employee.getEmpid()) return false;
        if (getEmpName() != null ? !getEmpName().equals(employee.getEmpName()) : employee.getEmpName() != null)
            return false;
        return getEmpsal() != null ? getEmpsal().equals(employee.getEmpsal()) : employee.getEmpsal() == null;
    }

    @Override
    public int hashCode() {
        int result = getEmpid();
        result = 31 * result + (getEmpName() != null ? getEmpName().hashCode() : 0);
        result = 31 * result + (getEmpsal() != null ? getEmpsal().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empName='" + empName + '\'' +
                ", empsal=" + empsal +
                '}';
    }
}
