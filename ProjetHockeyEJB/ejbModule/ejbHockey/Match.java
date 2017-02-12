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
	@NamedQuery(name="selectionToutMatch", query="SELECT p FROM Gardien p"),
})

public class Match implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String equipe;
	public Match(String nom, String equipe) {
		this.nom = nom;
		this.equipe = equipe;
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
	public String getEquipe() {
		return equipe;
	}
	public void setPrenom(String equipe) {
		this.equipe = equipe;
	}
	@Override
	public String toString() {
		return nom + " " + equipe;
	}
}
