package com.example.evolenta5_4.models.weathers;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Wind{
    private double speed;
    private int deg;
    private double gust;
}
