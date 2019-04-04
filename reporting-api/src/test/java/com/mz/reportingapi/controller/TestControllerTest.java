package com.mz.reportingapi.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest //a minimal spring context is loaded, just enough to test the web controllers, need to use @MockBean
@AutoConfigureMockMvc // MockMvc için
public class TestControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHello() {
		try {
			mvc.perform(get("/test/hello")
					.contentType(MediaType.APPLICATION_JSON)					
					.accept(MediaType.APPLICATION_JSON))
			         .andDo(print(System.out))
			         .andExpect(status().isOk())
			         .andExpect(content().string("Hello"));
			/*
			 * 

Reading these answers, I can see a lot relating to Spring version 4.x, I am using version 3.2.0 for various reasons. So things like json support straight from the content() is not possible.

I found that using MockMvcResultMatchers.jsonPath is really easy and works a treat. Here is an example testing a post method.
			 */
		} catch (Exception e) {	
			fail("Exception oldu:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
