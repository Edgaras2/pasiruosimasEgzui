package lt.bit.spring.pavasarineuzduotele;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static java.util.Comparator.comparing;
import java.time.LocalDate;

@SpringBootApplication
public class PavasarineuzduoteleApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(PavasarineuzduoteleApplication.class, args);
		
		//1,2,3 punktai?
		List<Studentas> st = StudentasService.gautiVisusStudentus();
		System.out.println("-----------");
		st.forEach(System.out::println);
		System.out.println("-----------");
		//4 punktas
		Collections.sort(st, comparing(Studentas::getPavarde).thenComparing(Studentas::getVardas));
		System.out.println("-----------");
		st.forEach(System.out::println);
		System.out.println("-----------");
		//5 punktas
		//PAGALVOJIMUI
//		Map<LocalDate, List<Integer>> list = st.stream()
//		.flatMap(s -> s.getPazymiai().stream())
//		.collect(Collectors.groupingBy(p -> p.getDate(), Collectors.toList(Pazymys::getPazymys)) );
//		System.out.println(list);
		List<Pazymys> list = st.stream()
		    .flatMap(s -> s.getPazymiai().stream())
		    .filter(p -> p.getDate().getYear() == 2018)
		    .collect(Collectors.toList());
		int avg = (int) list.stream()
		    .map(p -> p.getPazymys())
		    .reduce(0, (a,b) -> a + b)/list.size();
		System.out.println("vidurkis: " + avg);
	}
}
