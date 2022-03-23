package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.web.BookstoreController;

/**
 * "Smoke test". Testing the controller is not null. To run, run as Junit test
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
	public class ApplicationTests {

	// class name must be the same as the target controller
    @Autowired
    private BookstoreController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}