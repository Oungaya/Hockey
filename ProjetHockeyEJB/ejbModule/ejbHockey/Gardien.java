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
@Table(name = "gardien")


public class Gardien implements Serializable {
	@Id
	@Column(name = "gardien_id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	public Gardien(int id) {
		this.id = id;
	}
	public Gardien(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
}
