package lt.bit.uzduotele;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    List<Studentas> kolekcija = new ArrayList<>();
    kolekcija = uzkrautiDuomenis();
    for (Studentas studentas : kolekcija) {
      System.out.println(studentas.toString());
    }
    System.out.println("--------------");
    Collections.sort(kolekcija, new StudentuPalygintuvas());
    for (Studentas studentas : kolekcija) {
      System.out.println(studentas.toString());
    }
    System.out.println("--------------");
    System.out.println(kursoVidurkis(2018));
    
  }
  
  public static int kursoVidurkis(int metai) throws ClassNotFoundException, SQLException {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/dienynas", "root", "password");
    
    PreparedStatement st = con.prepareStatement(
        "SELECT pazymys FROM Pažymiai WHERE data LIKE '" + metai + "%'" );
//    st.setInt(1, metai);
    ResultSet rs = st.executeQuery();
    List<Integer> tarpinis = new ArrayList<>();
    while (rs.next()) {
    tarpinis.add(rs.getInt(1));
    }
    
    con.close();
    
    return (int) tarpinis.stream().reduce( 0, (a, b) -> a + b)/tarpinis.size();
  }

  public static List<Studentas> uzkrautiDuomenis() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/dienynas", "root", "password");
    PreparedStatement st = con.prepareStatement(
        "SELECT studentai.Id, studentai.vardas, studentai.pavarde, studentai.el_pastas, Pažymiai.pazymys\n"
            + "FROM studentai JOIN Pažymiai ON studentai.Id = Pažymiai.studentas_id;");
    ResultSet rs = st.executeQuery();
    List<Studentas> tarpinis = new ArrayList<>();
    while (rs.next()) {

      int id = rs.getInt(1);
      String vardas = rs.getString(2);
      String pavarde = rs.getString(3);
      String elPastas = rs.getString(4);

      Studentas stud = tarpinis.stream().filter(s -> s.getId() == id).findAny().orElseGet(() -> {
        Studentas stu = new Studentas(id, vardas, pavarde, elPastas);
        tarpinis.add(stu);
        return stu;
      });

      int pazymys = rs.getInt("pazymys");
      stud.getPazymiai().add(pazymys);
    }
    con.close();
    return tarpinis;
  }

  public static void uzkrautiDuomenisDu() {}
}
