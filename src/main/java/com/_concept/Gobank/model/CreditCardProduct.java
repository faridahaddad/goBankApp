package com._concept.Gobank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Data
@Entity
public class CreditCardProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CreditName;
    private String Bonus;
    private String description;
    private String imageUrl;




    @ManyToOne
    @JoinColumn(name= "userAdmin-id")
    private UserAdmin userAdmin;



}
