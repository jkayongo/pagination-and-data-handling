package workspace.PaginationAndDataHandling.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_table")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_department")
    private String department;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    public Employee() {

    }

    public Employee(String name, String department, LocalDate joiningDate) {
        this.name = name;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
