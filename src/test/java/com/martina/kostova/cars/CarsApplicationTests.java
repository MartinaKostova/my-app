package com.martina.kostova.cars;

import com.martina.kostova.cars.entity.Cars;
import com.martina.kostova.cars.entity.Colour;
import com.martina.kostova.cars.repository.CarsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.JsonPathAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
//@DataJpaTest
public class CarsApplicationTests {
//
//	@Autowired
//	private MockMvc mvc;
//
	@Autowired
	private CarsRepository repository;
//
//	@Test
//	public void whenFindByBrandThenReturnCar() {
//		Cars audi = new Cars("AUDI");
//		entityManager.persist(audi);
//		entityManager.flush();
//
//		Cars found = (Cars) repository.findByBrand(audi.getBrand());
//
//		assertThat(found.getBrand())
//				.isEqualTo(audi.getBrand());
//
//	}


//	@Test
//	public void findAll() throws Exception {
//		Cars cars = new Cars("Audi");
//
//		cars.setId(1L);
//		cars.setColour(Colour.BLACK);
//		cars.setSpeed(50);
//		cars.setBrand("Audi");
//		cars.setIsAwesome(true);
//
//		List<Cars> listCars = Arrays.asList(cars);
//		given(repository.findAll()).willReturn(listCars);
//
//		mvc.perform(get("/cars")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(1)))
//				.andExpect((ResultMatcher) jsonPath("$[0].name", is(cars.getBrand())));
//				.andExpect(content().json("[{\'id\': 2,\n" +
//						"        \'colour\': \'PINK\',\n" +
//						"        \'speed\': 320,\n" +
//						"        \'brand\': \'AUDI\',\n" +
//						"        \'isAwesome\': true}]"));


//	}

//	@Test
//	public void createItem() throws Exception {
//		RequestBuilder request = MockMvcRequestBuilders
//				.post("/cars")
//				.accept(MediaType.APPLICATION_JSON)
//				.content("{\"id\":1,\"colour\":\"BLACK\",\"speed\":10,\"brand\":\"AUDI\",\"isAwesome\":true}")
//				.contentType(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mvc.perform(request)
//				.andExpect(status().isOk()).andReturn();
//
//	}

}


