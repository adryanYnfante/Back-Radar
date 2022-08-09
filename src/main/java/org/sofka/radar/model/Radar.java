package org.sofka.radar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase entity representa la tabla
 * donde se almacenara los Radara.
 *
 *  @version  01.02.003 08/08/2022
 *  @author JD-Amaya
 *  @since 01.
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Radar {
    private String id;
    private String name;
}
