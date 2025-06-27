package com.assembleia.adm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdmAssembleiaApplicationTests {

	@Test
	void contextLoads() {
		String teste3 = "teste";
		String teste6 = "teste";
		assertEquals(teste3, teste6);
	}

}
