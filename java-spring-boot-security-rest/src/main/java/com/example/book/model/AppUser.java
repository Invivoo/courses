package com.example.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String userName;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<AppRole> roles = new ArrayList<>();
}
