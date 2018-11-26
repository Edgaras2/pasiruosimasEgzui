package lt.bit.uzduotele;

import java.util.Comparator;

public class StudentuPalygintuvas implements Comparator<Studentas> {

  @Override
  public int compare(Studentas stud1, Studentas stud2) {
    if (stud1.getPavarde().compareToIgnoreCase(stud2.getPavarde()) != 0) {
      return stud1.getPavarde().compareToIgnoreCase(stud2.getPavarde());
    } else {
      return stud1.getVardas().compareToIgnoreCase(stud2.getVardas());
    }

  }

}
