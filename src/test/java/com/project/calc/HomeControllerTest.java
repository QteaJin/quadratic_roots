package com.project.calc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.project.calc.controller.HomeController;


public class HomeControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private HomeController homeController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}

	@Test
	public void homeControllerTest() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());

	}

	@Test
	public void resultControllerTest1() throws Exception {

		this.mockMvc.perform(get("/getResult")).andExpect(status().is4xxClientError());

	}
	@Test
	public void resultControllerTest2() throws Exception {

		this.mockMvc.perform(post("/getResult")).andExpect(status().isOk());

	}
}
