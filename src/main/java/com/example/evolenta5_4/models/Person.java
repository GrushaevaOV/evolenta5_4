package com.example.evolenta5_4.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String name;
    @NonNull
    private String location;

    public Person(@NonNull String name, @NonNull String location) {
        this.name = name;
        this.location = location;
    }
}