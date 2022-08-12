package org.sofka.radar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RadarExterno {
    private String id;
    private String name;
    private String period;
    private String coach;
    private String year;
    private List<Apprentices> apprentices;



}
