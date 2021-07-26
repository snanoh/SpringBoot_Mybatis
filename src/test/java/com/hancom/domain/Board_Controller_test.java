package com.hancom.domain;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(Board_Controller.class)
@AutoConfigureMockMvc
public class Board_Controller_test {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void readTest() throws Exception {
		//given
		
		//when
		
		//then
		/*
		mockMvc.perform(get("/board/test"))
		       .andExpect(status().isOk())
		       .andExpect(content().string(equalTo("test")))  
		       .andDo(print());
		*/
		mockMvc.perform( MockMvcRequestBuilders .get("/board/test") // GET 요청 
				.accept(MediaType.APPLICATION_JSON) ) 
		        .andExpect(status().isOk()) 
		        .andExpect(content().string("test"))
		        .andDo(print());

		
	}
	
}
