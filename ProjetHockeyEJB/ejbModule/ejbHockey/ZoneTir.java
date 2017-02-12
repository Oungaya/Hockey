package ejbHockey;

import java.io.Serializable;
import javax.persistence.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
	@NamedQuery(name="selectionToutZoneTir", query="SELECT p FROM ZoneTir p"),
})

public class ZoneTir implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
    @OneToOne(mappedBy = "tirparzone")
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
