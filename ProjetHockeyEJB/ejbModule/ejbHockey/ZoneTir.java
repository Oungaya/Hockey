package ejbHockey;

import java.io.Serializable;
import javax.persistence.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "zonetir")
@NamedQueries ({
	@NamedQuery(name="selectionToutZoneTir", query="SELECT p FROM ZoneTir p"),
})

public class ZoneTir implements Serializable {
	@Id
	@Column(name = "zonetir_id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	public ZoneTir(String nom, String prenom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return nom;
	}
}
