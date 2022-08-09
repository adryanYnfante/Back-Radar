package org.sofka.radar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<KnowlegdeArea> knowlegdeAreas;
    public Radar(String id,String name){
        this.id=id;
        this.name=name;
        this.knowlegdeAreas= new ArrayList<>();
    }
}
