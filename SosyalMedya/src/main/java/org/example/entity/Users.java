package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String ad;
    @Column(unique = true)
    private String soyad;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;


}
