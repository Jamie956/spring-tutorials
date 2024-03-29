package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/")
	public String hi() {
		return "Message from port: " + port;
	}
}
