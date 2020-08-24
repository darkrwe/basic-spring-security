package com.myspring.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author emininal
 * @since 24.08.2020
 */

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2)
    @Column(nullable = false, name = "name")
    private String name;

    @Min(0)
    @Column(name = "age", nullable = false)
    private int age;


    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}

