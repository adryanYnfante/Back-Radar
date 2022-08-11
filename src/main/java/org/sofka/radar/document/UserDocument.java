package org.sofka.radar.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument {

    @Id
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String role;
    private String password;


}
