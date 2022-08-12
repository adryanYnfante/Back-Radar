package org.sofka.radar.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sofka.radar.model.KnowlegdeArea;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Radar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RadarDocument {
    @Id
    private String identification;
    private String name;
    private List<KnowlegdeArea> knowlegdeAreas;


}
