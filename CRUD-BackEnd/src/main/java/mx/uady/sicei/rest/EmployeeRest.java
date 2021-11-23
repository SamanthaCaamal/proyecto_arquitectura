package mx.uady.sicei.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.sicei.exception.ValidationExceptionsHandler;
import mx.uady.sicei.model.Employee;
import mx.uady.sicei.model.request.EmployeeRequest;
import mx.uady.sicei.service.EmployeeService;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeRequest request)
            throws URISyntaxException {
        Employee employee = employeeService.createEmployee(request);
        return ResponseEntity.created(new URI("/employee/" + employee.getId())).body(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> editEmployee(@RequestBody @Valid EmployeeRequest request,
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(id, request));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validateExceptions(MethodArgumentNotValidException ex) {
        ValidationExceptionsHandler exHandler = new ValidationExceptionsHandler(ex);
        return exHandler.handleValidationExceptions();
    }
}
