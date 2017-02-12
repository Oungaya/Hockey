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
import javax.persistence.OneToOne;
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
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="zonetir_fk",  referencedColumnName="zonetir_id", table="zonetir")
	private ZoneTir zoneTir;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="zonearret_fk",  referencedColumnName="zonearret_id", table="zonearret")
	private ZoneArret zoneArret;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="gardien_fk", referencedColumnName="gardien_id", table="gardien")
	private Gardien gardien;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="match_fk",  referencedColumnName="match_id", table="match")
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
