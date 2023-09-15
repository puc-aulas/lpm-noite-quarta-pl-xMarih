package com.alugueltech.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alugueltech.entity.Rental;
import com.alugueltech.service.RentalService;

@SpringBootTest
class RentalServiceTest {


	@Autowired
	RentalService rentalService;
	
	@Test
	void totalRevenueByMonthTest() {
		assertThat(rentalService.totalRevenueByMonth(9)).isEqualTo(8100);
		
	}
	@Test
	void rentalCalculatorlByIdTest() {
		assertThat(rentalService.rentalCalculatorlById((long) 2)).isEqualTo(29700);
	}
	
	@Test
	@SuppressWarnings("unlikely-arg-type")
	void monthlyReportTest() {
		
		List<Rental> rentals = rentalService.findRentalsByMonth(9);
		for (Rental rental : rentals) {
			assertThat(rental.getCliente()).isNotNull();
			assertThat(rental.getDoDate()).isNotNull();
		}
		
	}
	
	@Test 
	void readAllRentalTest () {
		 
		List<Rental> rentals = rentalService.readAllRental();
		for (Rental rental : rentals) {
			assertThat(rental.getCliente()).isNotNull();
			assertThat(rental.getDoDate()).isNotNull();
			assertThat(rental.getEquipment()).isNotNull();
			assertThat(rental.getEndDate()).isNotNull();
		}
	}
	
	@Test
	void findRentalByClientTest() {
		List<Rental> rentals = rentalService.findRentalByClient(6L);
		
		for (Rental rental : rentals) {
			assertThat(rental.getCliente()).isNotNull();
			assertThat(rental.getDoDate()).isNotNull();
			assertThat(rental.getEquipment()).isNotNull();
			assertThat(rental.getEndDate()).isNotNull();
		}
	}
	

	
	 

	
	
}
