package ejbHockey;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "utilisateur")
@NamedQueries ({
	@NamedQuery(name="selectionToutUtilisateur", query="SELECT p FROM Utilisateur p"),
	@NamedQuery(
		    name="verif_credentials",
		    query="SELECT c FROM Utilisateur c WHERE c.nom = :paramName AND c.mdp = :paramPassword"
		)
})

public class Utilisateur implements Serializable {
	@Id
	@Column(name = "utilisateur_id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String mdp;
	public Utilisateur(){
		
	}
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
