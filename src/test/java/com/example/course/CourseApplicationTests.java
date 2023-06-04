package com.example.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CourseApplicationTests {

	@Mock
	OrderRepository orderRepository;
	@InjectMocks
	OrderService orderService;
	@Test
	void contextLoads() {
	}
	@Test
	void testOrder(){
		Order order = new Order();
		order.setId(1L);
		Mockito.when(this.orderRepository.findById(1L)).thenReturn(Optional.of(order));

		Assertions.assertEquals(order,this.orderService.findById(1L));
	}

}
