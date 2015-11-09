package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class TicketID implements Serializable {

	private Integer idPassenger;
	private Integer idFlight;

	public TicketID() {
	}

	public TicketID(Integer idPassenger, Integer idFlight) {
		super();
		this.idPassenger = idPassenger;
		this.idFlight = idFlight;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFlight == null) ? 0 : idFlight.hashCode());
		result = prime * result
				+ ((idPassenger == null) ? 0 : idPassenger.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketID other = (TicketID) obj;
		if (idFlight == null) {
			if (other.idFlight != null)
				return false;
		} else if (!idFlight.equals(other.idFlight))
			return false;
		if (idPassenger == null) {
			if (other.idPassenger != null)
				return false;
		} else if (!idPassenger.equals(other.idPassenger))
			return false;
		return true;
	}

	@Column(name = "idPassenger")
	public Integer getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Integer idPassenger) {
		this.idPassenger = idPassenger;
	}

	@Column(name = "idFlight")
	public Integer getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}

}
