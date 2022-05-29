package io.github.anantharajuc.aes.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @Column(name="address")
    String address;
}
