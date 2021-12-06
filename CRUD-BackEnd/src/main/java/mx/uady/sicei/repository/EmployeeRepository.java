package mx.uady.sicei.repository;
/**
 * Interfaz para realizar queries dentro de la Base de Datos
 * @author Samantha Caamal, Montserrat Bustamante 
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.sicei.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

}
