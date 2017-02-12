package ejbHockey;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
	@NamedQuery(name="selectionToutTirParZone", query="SELECT p FROM TirParZone p"),
})

public class TirParZone implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private int nbTir;
	private ZoneTir zoneTir;
	private ZoneArret zoneArret;
	private Gardien gardien;
	private Match match;

	
	public TirParZone(int nbTir, ZoneTir zoneTir, ZoneArret zoneArret, Gardien gardien, Match match) {
		this.nbTir = nbTir;
		this.zoneTir = zoneTir;
		this.zoneArret = zoneArret;
		this.gardien = gardien;
		this.match = match;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbTir() {
		return nbTir;
	}

	public void setNbTir(int nbTir) {
		this.nbTir = nbTir;
	}

	public ZoneTir getZoneTir() {
		return zoneTir;
	}

	public void setZoneTir(ZoneTir zoneTir) {
		this.zoneTir = zoneTir;
	}

	public ZoneArret getZoneArret() {
		return zoneArret;
	}

	public void setZoneArret(ZoneArret zoneArret) {
		this.zoneArret = zoneArret;
	}

	public Gardien getGardien() {
		return gardien;
	}

	public void setGardien(Gardien gardien) {
		this.gardien = gardien;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
