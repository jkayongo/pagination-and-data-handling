package workspace.PaginationAndDataHandling.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workspace.PaginationAndDataHandling.model.Employee;
import workspace.PaginationAndDataHandling.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Employee>> fetchAllEmployees(@RequestParam(required = false, defaultValue = "0") int pageNumber,
                                                            @RequestParam(required = false, defaultValue = "5")int pageSize,
                                                            @RequestParam(required = false, defaultValue = "id") String fieldToSortBy,
                                                            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
                                                            @RequestParam(required = false) String search){

        Sort sort = sortDirection.equalsIgnoreCase("ASC")?
                Sort.by(fieldToSortBy).ascending(): Sort.by(fieldToSortBy).descending();

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        List<Employee> employees = employeeService.fetchAllEmployees(pageRequest);
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        Employee employeeRecord = employeeService.save(employee);
        return ResponseEntity.ok(employeeRecord);
    }
}
