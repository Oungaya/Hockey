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
@Table(name = "matchhockey")


public class Match implements Serializable {
	@Id
	@Column(name = "matchhockey_id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String equipe;
	private String date;
	public Match(int idMatch){
		this.id = idMatch;
	}
	public Match(String nom, String equipe, String date) {
		this.nom = nom;
		this.equipe = equipe;
		this.setDate(date);
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
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return nom + " " + equipe;
	}

}
