package org.sofka.radar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Clase entity representa la tabla
 * donde se almacenara los usuarios.
 *
 *  @version  01.02.003 06/08/2022
 *  @author JD-Amaya
 *  @since 01.
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String role;
    private String password;

}
