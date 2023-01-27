package elisa.fi.interview.exercise.searchapplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
        title = "Search Min Positive Number API",
        version = "1.0.0"
),
        servers = {@Server(url = "http://localhost:8080/", description = "Local Server URL")}

)
@SpringBootApplication
public class SearchApplication {

  public static void main(String[] args) {
    SpringApplication.run(SearchApplication.class, args);
  }
}
