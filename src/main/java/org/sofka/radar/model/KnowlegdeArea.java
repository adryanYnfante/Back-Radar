package org.sofka.radar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class KnowlegdeArea {
    private String name;
    private String descriptor;
    private List<Float> levels;
    private Float appropriationLevel;
}
