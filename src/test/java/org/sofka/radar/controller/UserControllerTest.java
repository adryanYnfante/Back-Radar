package org.sofka.radar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Mock
    UserController userController;

    private WebTestClient client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void getUserAll() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void getUserId() {
    }

    @Test
    void loginWithEmail() {
    }

    @Test
    void loginEmail() {
    }
}