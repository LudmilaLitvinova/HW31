package com.example.hw31.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ludmila Litvinova on 09.02.23
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "my_store")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole userRole;
}
