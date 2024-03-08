package com.majornick.taskholder.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name = "user_seq",sequenceName = "user_seq")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private long id;
    @Column(unique = true)
    private String username;

}


