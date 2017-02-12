package ejbHockey;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
	@NamedQuery(name="selectionToutUtilisateur", query="SELECT p FROM Utilisateur p"),
})

public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String mdp;
	public Utilisateur(String nom, String mdp) {
		this.nom = nom;
		this.mdp = mdp;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return nom;
	}
}
