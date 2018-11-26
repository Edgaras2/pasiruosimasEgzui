package lt.bit.spring.pavasarineuzduotele;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentasService {
  
  private static StudentasJpaRepository rep;
  
  public StudentasService(StudentasJpaRepository rep) {
    this.rep = rep;
  }
  
  public static List<Studentas> gautiVisusStudentus(){
    return rep.findAll();
  }
  

}
