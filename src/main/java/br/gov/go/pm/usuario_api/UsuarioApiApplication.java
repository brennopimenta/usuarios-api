package br.gov.go.pm.usuario_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuarioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApiApplication.class, args);
	}

}


// **** Codigo Para rodar em TomCat Externo
//@SpringBootApplication
//public class UsuarioApiApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(UsuarioApiApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(UsuarioApiApplication.class, args);
//	}
//
//
//
//}
