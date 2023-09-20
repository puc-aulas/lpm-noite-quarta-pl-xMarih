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

		assertNull(rentalService.totalRevenueByMonth(15));
		assertNotNull(rentalService.totalRevenueByMonth(9));
		assertNotEquals(0, rentalService.totalRevenueByMonth(9));
		
	}
	@Test
	void rentalCalculatorlByIdTest() {
		assertNull(rentalService.rentalCalculatorlById(0));
		assertEquals(29700, rentalService.rentalCalculatorlById((long) 2));
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
