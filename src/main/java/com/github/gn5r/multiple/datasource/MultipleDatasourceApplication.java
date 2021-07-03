package com.github.gn5r.multiple.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = FQCNBeanNameGenerator.class)
public class MultipleDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatasourceApplication.class, args);
	}

}
