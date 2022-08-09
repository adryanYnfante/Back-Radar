package org.sofka.radar.document;

import lombok.AllArgsConstructor;
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
public class RadarDocument {
    @Id
    private String identification;
    private String name;
    private List<KnowlegdeArea> knowlegdeAreas;


    public RadarDocument(String identification,String name){
        this.identification=identification;
        this.name=name;
        this.knowlegdeAreas= new ArrayList<>();
    }
}
