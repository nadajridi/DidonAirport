package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServicesRemote {
	Boolean addEmployee (Employee employee);
	Boolean updateEmployee (Employee employee);
	Boolean deleteEmployee (Employee employee);
	Employee findEmployeeById (Integer id);
	List<Employee> findAllEmployees();

}
