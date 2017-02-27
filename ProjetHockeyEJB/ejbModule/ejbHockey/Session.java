package ejbHockey;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "session")
@NamedQueries ({
	@NamedQuery(name="checkToken", query="SELECT p FROM Session p WHERE token = :paramToken AND validity > :paramValidity"),
	@NamedQuery(name="findSessionWithToken", query="SELECT p FROM Session p WHERE token = :paramToken"),
})
public class Session implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String token;
	private double validity;
	
	public Session() {

	}
	public Session (String token, double validity)
	{
		this.token = token;
		this.validity = validity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public double getValidity() {
		return validity;
	}
	public void setValidity(double validity) {
		this.validity = validity;
	}

}
