package org.sofka.radar.service;


import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    final
    IUserRepository usuarioRepository;



    public UserService( IUserRepository userRepository) {
        this.usuarioRepository = userRepository;

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


    public  Mono<UserDocument> findUserByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }


}
