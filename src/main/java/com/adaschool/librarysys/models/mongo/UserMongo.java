package com.adaschool.librarysys.models.mongo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class UserMongo {
    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String rol;
}
