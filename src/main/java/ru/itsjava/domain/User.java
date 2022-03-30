package ru.itsjava.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

    @OneToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
