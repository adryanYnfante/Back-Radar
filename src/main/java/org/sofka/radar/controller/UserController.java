package org.sofka.radar.controller;


import org.sofka.radar.document.UserDocument;
import org.sofka.radar.model.Token;
import org.sofka.radar.service.JwtHelper;
import org.sofka.radar.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    final
    UserService userService;

    final JwtHelper jwt = new JwtHelper();

    public UserController(UserService userService) {
        this.userService = userService;


    }


    /**
     * Permite obtener todas las Usuario almacenadas.
     *
     * @return lista de usuarios.
     */
    @GetMapping
    public Flux<UserDocument> getUserAll() {
        return userService.getUsuarioAll();
    }

    /**
     * Permite guardar en base de datos una tarea
     *
     * @param user tarea a ser almacenada
     * @return tarea almacenada con su id incluido
     */
    @PostMapping
    public Mono<UserDocument> saveUser(@RequestBody UserDocument user) {
        return userService.saveUser(user);
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param id id de la tarea a buscar
     * @return objeto completo encontrado.
     */

    @GetMapping("/{id}")
    public Mono<UserDocument> getUserId(@PathVariable String id) {
        return userService.getUsuarioId(id);
    }

    @PostMapping("/login")
    public Mono<ServerResponse> loginWithEmail() {

        return userService.findUserByEmail("sopas@gmail.com")
                .map(userDocument -> jwt.createJwt(userDocument))
                .flatMap(token -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(token, String.class));

        //   .map(userDocument -> jwt.generateLoginToken(userDocument)).switchIfEmpty(Mono.error(new IllegalAccessError("No existe")));
    }

    @GetMapping("/login/{email}")
    public Mono<ResponseEntity<Token>> loginEmail(@PathVariable String email) {
        return userService.findUserByEmail(email)
                .map(userDocument ->
                        jwt.createJwt(userDocument)
                ).map(token -> {
                    var tokesito = new Token(token);
                    return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(tokesito);
                })
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new Token("Usuario no Encontrado"))));

    }
}
