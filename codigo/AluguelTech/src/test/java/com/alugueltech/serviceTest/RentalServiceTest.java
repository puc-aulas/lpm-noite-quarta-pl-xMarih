package com.alugueltech.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alugueltech.service.RentalService;

@SpringBootTest
class RentalServiceTest {


	@Autowired
	RentalService rentalService;
	
	@Test
	void calculaValorAluguelTest() {
		assertThat(rentalService.rentalCalculatorlById((long) 2)).isEqualTo(29700);
	}
	
}
