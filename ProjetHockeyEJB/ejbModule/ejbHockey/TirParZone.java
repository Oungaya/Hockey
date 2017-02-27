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
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "tirparzone")
@NamedQueries ({
	@NamedQuery(name="selectionToutTirParZone", query="SELECT p FROM TirParZone p"),
	@NamedQuery(name="selectionUnTirParZone", query="SELECT p FROM TirParZone p where zonearret_id= :zonearret and zonetir_id = :zonetir and match_id= :match and gardien_id = :gardien"),
	@NamedQuery(name="selectionNbTirZoneTir", query="SELECT p FROM TirParZone p where zonetir_id = :zonetir and match_id= :match and gardien_id = :gardien"),
	@NamedQuery(name="selectionNbTirZoneTirAll", query="SELECT p FROM TirParZone p where zonetir_id = :zonetir and gardien_id = :gardien"),
	@NamedQuery(name="selectionNbTirZoneArret", query="SELECT p FROM TirParZone p where zonearret_id = :zonearret and match_id= :match and gardien_id = :gardien"),
	@NamedQuery(name="selectionNbTirZoneArretAll", query="SELECT p FROM TirParZone p where zonearret_id = :zonearret and gardien_id = :gardien")

})

public class TirParZone implements Serializable {
	@Id
	@Column(name = "tirparzone_id")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private int nbTir;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="zonetir_id")
	private ZoneTir zoneTir;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="zonearret_id")
	private ZoneArret zoneArret;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="gardien_id")
	private Gardien gardien;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="match_id")
	private Match match;
	@Column(name = "but")
	int but;

	public TirParZone(){}

	public TirParZone(int nbTir, ZoneTir zonetir, ZoneArret zonearret, Gardien gardien, Match match, int but) {
		this.nbTir = nbTir;
		this.but = but;
		this.zoneTir = zonetir;
		this.zoneArret = zonearret;
		this.gardien = gardien;
		this.match = match;
	}
	public int getBut(){
		return but;
	}
	public void setBut(int but){
		this.but = but;
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
