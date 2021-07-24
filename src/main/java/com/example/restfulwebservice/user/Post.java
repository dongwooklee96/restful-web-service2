package com.example.restfulwebservice.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Generated
    private Integer id;

    private String description;

    // User : Post -> 1 : N
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
