package org.sofka.radar.controller;


import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IUserRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    final
    IUserRepository iUserRepository;


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
     * @param idUser id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    @GetMapping("/searchbyid")
    public Mono<UserDocument> getUserId(String idUser) {
        return iUserRepository.findById(idUser);
    }
}
