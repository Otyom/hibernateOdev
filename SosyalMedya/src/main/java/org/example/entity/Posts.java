package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.xml.stream.events.Comment;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Posts{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(unique = true)
    private String post;

/*
    @SuppressWarnings("JpaAttributeTypeInspection")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "kullanıci_yorum", joinColumns = {@JoinColumn(name = "id")},inverseJoinColumns = {@JoinColumn(name = "id")})
    private Comment comment;
*/

    public Posts(String post) {
        this.post = post;
    }
}

