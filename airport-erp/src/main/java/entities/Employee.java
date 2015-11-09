package entities;

import entities.Passenger;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@DiscriminatorValue(value ="employee")
public class Employee extends Passenger implements Serializable {

	
	private String department;
	private String position;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}   
	
	
	
	public Employee(String department, String position) {
		super();
		this.department = department;
		this.position = position;
	}



	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}   
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
   
}
