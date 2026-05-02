package com.github.jadilson22a.TaskProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jadilson22a.TaskProject.Service.TarefaService;

@SpringBootTest
class TaskProjectApplicationTests {
	
	@Autowired
	private TarefaService service;

	@Test
	void contextLoads() {		
		
	}

}
