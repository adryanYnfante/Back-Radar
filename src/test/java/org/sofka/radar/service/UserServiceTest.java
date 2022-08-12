package org.sofka.radar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IUserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static  org.mockito.Mockito.when;

class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    IUserRepository userRepository;

    private UserDocument user;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

    }

    @Test
    void saveUser() {
        user = UserDocument.builder()
                .identification("1234")
                .name("juan")
                .lastName("Amaya")
                .password("1234")
                .role("Administrador")
                .build();


        when(userRepository.save(user)).thenReturn(Mono.just(user));

        StepVerifier.create(userService.saveUser(user))
                .assertNext(userDocument -> {
                    Assertions.assertEquals("1234", userDocument.getIdentification());
                })
                .expectComplete()
                .verify();
    }

    @Test
    void getUsuarioAll() {

        user = UserDocument.builder()
                .identification("1234")
                .name("juan")
                .lastName("Amaya")
                .password("1234")
                .role("Administrador")
                .build();

        List<UserDocument> list = new ArrayList<>();
        list.add(user);
        when(userRepository.findAll()).thenReturn(Flux.fromStream(list.stream()));

        StepVerifier.create(userService.getUsuarioAll().collectList())
                .assertNext(userDocument -> {
                    Assertions.assertEquals(1, userDocument.size());
                })
                .expectComplete()
                .verify();
    }

    @Test
    void getUsuarioId() {
        user = UserDocument.builder()
                .identification("1234")
                .name("juan")
                .email("juan@gmail.com")
                .lastName("Amaya")
                .password("1234")
                .role("Administrador")
                .build();

       UserDocument user1 = UserDocument.builder()
                .identification("4321")
                .name("david")
                .lastName("Amaya")
                .email("david@gmail.com")
                .password("1234")
                .role("Consultor")
                .build();

        List<UserDocument> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        when(userRepository.findById("1234")).thenReturn(Mono.just(user));

        StepVerifier.create(userService.getUsuarioId("1234"))
                .assertNext(userDocument -> {
                    Assertions.assertEquals("1234", userDocument.getIdentification());
                })
                .expectComplete()
                .verify();
    }

    @Test
    void findUserByEmail() {
        user = UserDocument.builder()
                .identification("1234")
                .name("juan")
                .lastName("Amaya")
                .email("judasayn@gmail.com")
                .password("1234")
                .role("Administrador")
                .build();

        List<UserDocument> list = new ArrayList<>();
        list.add(user);
        when(userRepository.findByEmail("judasayn@gmail.com")).thenReturn(Mono.just(user));

        StepVerifier.create(userService.findUserByEmail("judasayn@gmail.com"))
                .assertNext(userDocument -> {
                    Assertions.assertEquals("1234", userDocument.getIdentification());
                    Assertions.assertEquals("judasayn@gmail.com", userDocument.getEmail());
                    Assertions.assertEquals("Administrador", userDocument.getRole());
                })
                .expectComplete()
                .verify();
    }
}