package dhbw.leftlovers.angebotsservice;

import dhbw.leftlovers.angebotsservice.register.ServiceRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngebotsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngebotsserviceApplication.class, args);
		ServiceRegistration.registerInServiceRegister();
	}
}
