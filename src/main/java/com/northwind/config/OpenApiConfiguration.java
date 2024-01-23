package com.northwind.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	    info = @Info(
	        title = "Northwind API",
	        version = "1.0",
	        description = "API para gestionar información de la empresa Northwind",
	        contact = @Contact(
	            name = "Ronaldo Lobato",
	            email = "contactoronaldolobato@gmail.com",
	            url = "https://github.com/RonaldoLobatoCode"
	        )
	    )
	)
public class OpenApiConfiguration {

}

