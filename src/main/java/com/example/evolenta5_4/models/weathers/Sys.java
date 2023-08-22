package com.example.evolenta5_4.models.weathers;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sys{
    private String country;
    private int sunrise;
    private int sunset;
}
