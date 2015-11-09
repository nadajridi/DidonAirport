package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Meal
 *
 */
@Entity
@Table(name = "t_meal")
public class Meal implements Serializable {

	private Integer id;
	@Enumerated(EnumType.STRING)
	private MealCategory category;
	private String name;
	private float price;
	private Integer quantity;
	@ManyToOne
	private Passenger passenger;
	@ManyToOne
	private Provider provider;
	private static final long serialVersionUID = 1L;

	public Meal() {
		super();
	}

	public Meal(MealCategory category, String name, float price,
			Integer quantity, Passenger passenger, Provider provider) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.passenger = passenger;
		this.provider = provider;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MealCategory getCategory() {
		return this.category;
	}

	public void setCategory(MealCategory category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@ManyToOne
	@JoinColumn(name = "idPassenger", referencedColumnName = "id", updatable = false, insertable = true)
	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@ManyToOne
	@JoinColumn(name = "idProvider", referencedColumnName = "id", updatable = false, insertable = true)
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}
