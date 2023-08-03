package com.example.controlfinances.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "name")
    private String name;

}
