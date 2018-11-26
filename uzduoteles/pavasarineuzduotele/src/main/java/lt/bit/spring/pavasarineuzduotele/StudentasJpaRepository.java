package lt.bit.spring.pavasarineuzduotele;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentasJpaRepository extends JpaRepository<Studentas, Integer> {
  
}
