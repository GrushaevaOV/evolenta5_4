package com.example.evolenta5_4.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String title;

    @NonNull
    private long lng;

    @NonNull
    private long lat;

    public Location(@NonNull String title, @NonNull long lng, @NonNull long lat) {
        this.title = title;
        this.lng = lng;
        this.lat = lat;
    }
}
