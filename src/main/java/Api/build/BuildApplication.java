package Api.build;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildApplication.class, args);

		System.out.println("Ready to deploy...");
	}

}
