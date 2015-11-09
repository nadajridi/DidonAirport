package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employee;
import services.interfaces.EmployeeServicesLocal;
import services.interfaces.EmployeeServicesRemote;

/**
 * Session Bean implementation class EmployeeServices
 */
@Stateless
public class EmployeeServices extends PassengerServices implements EmployeeServicesRemote, EmployeeServicesLocal {
      
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * @see PassengerServices#PassengerServices()
     */
    public EmployeeServices() {
        super();
   
    }

	@Override
	public Boolean addEmployee(Employee employee) {
		Boolean b = false;
		try {
			entityManager.persist(employee);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		Boolean b = false;
		try {
			entityManager.merge(employee);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		Boolean b = false;
		try {
			employee = findEmployeeById(employee.getId());
			entityManager.remove(employee);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return entityManager.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
	String	jpql = "select e from t_user e where e.function='emp'";
			Query query =entityManager.createQuery(jpql);
			return  query.getResultList();
	}

}
