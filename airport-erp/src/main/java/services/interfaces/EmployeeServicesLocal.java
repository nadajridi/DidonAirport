package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Employee;

@Local
public interface EmployeeServicesLocal {
	
	Boolean addEmployee (Employee employee);
	Boolean updateEmployee (Employee employee);
	Boolean deleteEmployee (Employee employee);
	Employee findEmployeeById (Integer id);
	List<Employee> findAllEmployees();

}
