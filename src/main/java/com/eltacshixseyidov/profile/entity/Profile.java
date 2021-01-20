package com.eltacshixseyidov.profile.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String description;

    public Profile(String fileName) {
        this.fileName = fileName;
    }

    public Profile(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
    }
}
