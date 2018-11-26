package lt.bit.spring.pavasarineuzduotele;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author gediminas
 * @version 1L class used for uzduotele
 */
@Entity
@Table(name = "studentai")
public class Studentas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vardas;
	private String pavarde;
	@Column(name = "el_pastas")
	private String elPastas;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "pazymiai", joinColumns = @JoinColumn(name = "studentas_id", referencedColumnName = "Id"))
	private List<Pazymys> pazymiai;

	public Studentas() {
	}

	public Studentas(int id, String vardas, String pavarde, String elPastas) {
		this.id = id;
		this.vardas = vardas;
		this.pavarde = pavarde;
		this.elPastas = elPastas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}

	public String getElPastas() {
		return elPastas;
	}

	public void setElPastas(String elPastas) {
		this.elPastas = elPastas;
	}

	public List<Pazymys> getPazymiai() {
		return pazymiai;
	}

	public void setPazymiai(List<Pazymys> pazymiai) {
		this.pazymiai = pazymiai;
	}

	@Override
	public String toString() {
		return "Studentas [id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + ", elPastas=" + elPastas
				+ ", pazymiai=" + pazymiai + "]";
	}

}

@Embeddable
class Pazymys {

	private LocalDate data;
	private Integer pazymys;

	public Pazymys() {
	}

	public Pazymys(LocalDate date, Integer pazymys) {
		this.data = date;
		this.pazymys = pazymys;
	}

	public LocalDate getDate() {
		return data;
	}

	public void setDate(LocalDate date) {
		this.data = date;
	}

	public Integer getPazymys() {
		return pazymys;
	}

	public void setPazymys(Integer pazymys) {
		this.pazymys = pazymys;
	}

	@Override
	public String toString() {
		return "Pazymys [data=" + data + ", pazymys=" + pazymys + "]";
	}

}
