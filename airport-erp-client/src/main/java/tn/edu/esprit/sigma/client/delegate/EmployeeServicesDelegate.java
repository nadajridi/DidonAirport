package tn.edu.esprit.sigma.client.delegate;

import java.util.List;

import services.interfaces.EmployeeServicesRemote;
import tn.edu.esprit.sigma.client.locator.ServiceLocator;
import entities.Employee;

public class EmployeeServicesDelegate {
	
private static final String jndi="airport-erp/EmployeeServices!services.interfaces.EmployeeServicesRemote";
	
	private static EmployeeServicesRemote getProxy()
	{
		return (EmployeeServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
public static	Boolean doAddEmployee (Employee employee)
	{
		return getProxy().addEmployee(employee);
	}
public static	Boolean doUpdateEmployee (Employee employee)
	{
		return getProxy().updateEmployee(employee);
	}
public static	Boolean doDeleteEmployee (Employee employee)
	{
		return getProxy().deleteEmployee(employee);
	}
public static	Employee doFindEmployeeById (Integer idEmployee)
	{
		return getProxy().findEmployeeById(idEmployee);
	}
public static	List<Employee> doFindAllEmployees()
	{
		return getProxy().findAllEmployees();
	}

}
