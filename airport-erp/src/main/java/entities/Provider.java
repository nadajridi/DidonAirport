package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity
@Table(name = "t_provider")
public class Provider implements Serializable {

	
	private Integer id;
	private String managerName;
	private String companyName;
	private String email;
	private String password;
	private Number phoneNumber;
	private static final long serialVersionUID = 1L;
	
	private List<Meal> meals;

	public Provider() {
		super();
	}  
	
	
	
	public Provider(String managerName, String companyName, String email,
			String password, Number phoneNumber) {
		super();
		this.managerName = managerName;
		this.companyName = companyName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}



	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}   
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}   
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Number getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Number phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@OneToMany(mappedBy = "provider", cascade = CascadeType.MERGE)
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public void linkMealsToThisProvider(List<Meal> meals) {
		this.meals = meals;
		for (Meal m : meals) {
			m.setProvider(this);
		}
	}
   
}
