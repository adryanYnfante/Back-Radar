package org.sofka.radar.controller;


import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IUserRepository;
import org.sofka.radar.service.JwtHelper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    final
    IUserRepository iUserRepository;
    final JwtHelper jwt = new JwtHelper();


    public UserController(IUserRepository userRepository) {
        this.iUserRepository = userRepository;

    }

    /**
     * Permite obtener todas las Usuario almacenadas.
     *
     * @return lista de usuarios.
     */
    @GetMapping
    public Flux<UserDocument> getUserAll() {
        return iUserRepository.findAll();
    }

    /**
     * Permite guardar en base de datos una tarea
     *
     * @param user tarea a ser almacenada
     * @return tarea almacenada con su id incluido
     */
    @PostMapping
    public Mono<UserDocument> saveUser(@RequestBody UserDocument user) {
        return iUserRepository.save(user);
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param id id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    @GetMapping("/{id}")
    public Mono<UserDocument> getUserId(@PathVariable  String id) {
        return iUserRepository.findById(id);
    }

    @PostMapping("/login")
    public Mono<ServerResponse> loginWithEmail(){

           return     iUserRepository.findByEmail("sopas@gmail.com")
                       .map(userDocument -> jwt.createJwt(userDocument))
                        .flatMap(token -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                           .body(token, String.class));

             //   .map(userDocument -> jwt.generateLoginToken(userDocument)).switchIfEmpty(Mono.error(new IllegalAccessError("No existe")));
    }
    @GetMapping("/login/{email}")
    public Mono<String> loginEmail(@PathVariable String email){
       return iUserRepository.findByEmail(email)
               .map(userDocument ->
             jwt.createJwt(userDocument)
        );
    }
}
