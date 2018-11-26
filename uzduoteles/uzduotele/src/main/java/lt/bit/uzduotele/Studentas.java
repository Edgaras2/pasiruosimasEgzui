package lt.bit.uzduotele;

import java.util.LinkedList;
import java.util.List;

/**
 * @author gediminas
 * @version 1L
 * class used for uzduotele
 */
public class Studentas {
  
  private int id;
  private String vardas;
  private String pavarde;
  private String elPastas;
  private List<Integer> pazymiai = new LinkedList<>();
  
  
  
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
  public List<Integer> getPazymiai() {
    return pazymiai;
  }
  public void setPazymiai(List<Integer> pazymiai) {
    this.pazymiai = pazymiai;
  }
  @Override
  public String toString() {
    return "Studentas [id=" + id + ", vardas=" + vardas + ", pavarde=" + pavarde + ", elPastas="
        + elPastas + ", pazymiai=" + pazymiai + "]";
  }

  
}
