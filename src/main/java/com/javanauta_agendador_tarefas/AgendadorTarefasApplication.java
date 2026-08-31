package com.javanauta_agendador_tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Habilitando o Feign Client para http de outros serviços
public class AgendadorTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorTarefasApplication.class, args);
	}

}
