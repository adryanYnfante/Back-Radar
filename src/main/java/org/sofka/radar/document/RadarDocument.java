package org.sofka.radar.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Radar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadarDocument {
    @Id
    private String identification;
    private String name;

}
