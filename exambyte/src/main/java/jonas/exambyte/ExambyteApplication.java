package jonas.exambyte;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jonas.exambyte.domain.model.Quiz;
import jonas.exambyte.domain.service.ExambyteService;

@SpringBootApplication
public class ExambyteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExambyteApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(ExambyteService exambyteService) {
	// 	return args -> {
	// 		long id = exambyteService.quizHinzufuegen();
	// 		System.out.println(id);
	// 		System.out.println("-----------------");
	// 		exambyteService.deleteQuizById(id);
	// 	};
	// }

}
