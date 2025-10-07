package workspace.PaginationAndDataHandling.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import workspace.PaginationAndDataHandling.model.Employee;
import workspace.PaginationAndDataHandling.repository.EmployeeRepository;


import java.util.List;

@Service
public class EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> fetchAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable).getContent();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
}
