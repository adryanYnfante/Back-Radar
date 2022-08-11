package org.sofka.radar.service;


import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IUserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    final
    IUserRepository usuarioRepository;

   private final String url = "http://localhost:8080/";
    private WebClient webClient;

    public UserService(WebClient.Builder webClientBuilder, IUserRepository userRepository) {
        this.usuarioRepository = userRepository;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    /**
     * Permite guardar en base de datos una tarea
     *
     * @param usuario tarea a ser almacenada
     * @return tarea almacenada con su id incluido
     */
    public Mono<UserDocument> saveUser(UserDocument usuario){

        return usuarioRepository.save(usuario);
    }


    /**
     * Permite obtener todas las tareas almacenadas.
     *
     * @return lista de tareas.
     */
    public Flux<UserDocument> getUsuarioAll(){
        return usuarioRepository.findAll();
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param idUsuario id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    public Mono<UserDocument> getUsuarioId(String idUsuario){
        return usuarioRepository.findById(idUsuario);
    }


    public Flux<UserDocument> getData(){
        return  webClient.get()
                .uri("league")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(UserDocument.class);
    }
}
