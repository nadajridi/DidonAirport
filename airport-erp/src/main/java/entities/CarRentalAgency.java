package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CarRentalAgency
 *
 */
@Entity
@Table(name = "t_car_rental_agency")
public class CarRentalAgency implements Serializable {

	private Integer id;
	private String email;
	private String companyName;
	private String managerName;
	private Number phoneNumber;
	private String password;
	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	public CarRentalAgency() {
		super();
	}

	public CarRentalAgency(String email, String companyName,
			String managerName, Number phoneNumber, String password) {
		super();
		this.email = email;
		this.companyName = companyName;
		this.managerName = managerName;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "company_name")
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "manager_name")
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "phone_number")
	public Number getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Number phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "agency", cascade = CascadeType.MERGE)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
