package richard.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import richard.backend.restapi.Lib;

@SpringBootApplication
public class RichardTemplateApplication {
	
	public static final int PORT_SERVER = 8080;
	
	public static void main(String[] args) {
		SpringApplication.run(RichardTemplateApplication.class, args);
		String ip = Lib.getIp().get(0);
		System.out.println("***********************************************************->"+ip);
		System.out.println("Your API :	http://localhost:"+PORT_SERVER+"/swagger-ui.html");
		System.out.println("Your API :	http://"+ip+":" + PORT_SERVER + "/swagger-ui.html");
		System.out.println("***********************************************************");
	}
	
	
//	@Configuration
//	public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
//		public void customize(ConfigurableServletWebServerFactory factory) {
//			factory.setPort(PORT_SERVER);
//		}
//	}
}
