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
	@NamedQuery(name="selectionUnTirParZone", query="SELECT p FROM TirParZone p where zonearret_id= :zonearret and zonetir_id = :zonetir and match_id= :match and gardien_id = :gardien")
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

	public TirParZone(){}
	public TirParZone(int nbTir, int idZoneTir, int idZoneArret, int idGardien, int idMatch){
		this.nbTir = nbTir;
		this.zoneTir = new ZoneTir(idZoneTir);
		this.zoneArret = new ZoneArret(idZoneArret);
		this.gardien = new Gardien(idGardien);
		this.match = new Match(idMatch);
	}
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
