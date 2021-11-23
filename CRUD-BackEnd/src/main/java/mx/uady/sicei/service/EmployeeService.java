package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.uady.sicei.model.Employee;
import mx.uady.sicei.model.request.EmployeeRequest;
import mx.uady.sicei.repository.EmployeeRepository;
import mx.uady.sicei.exception.NotFoundException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> employees = new LinkedList<>();

        employeeRepository.findAll().iterator().forEachRemaining(employees::add); // SELECT(id, nombre)

        return employees;
    }

    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new NotFoundException("No se encontró un usuario con id " + id);
        }
        return employee.get();
    }

    @Transactional
    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setAddress(request.getAddress());
        employee.setPhone(request.getPhone());
        employeeRepository.save(employee);
        return employee;
    }

    @Transactional
    public Employee updateEmployee(Integer id, EmployeeRequest request) {
        Employee foundEmployee = getEmployeeById(id);
        foundEmployee.setName(request.getName());
        foundEmployee.setEmail(request.getEmail());
        foundEmployee.setAddress(request.getAddress());
        foundEmployee.setPhone(request.getPhone());

        employeeRepository.save(foundEmployee);
        return foundEmployee;
    }

    @Transactional
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
