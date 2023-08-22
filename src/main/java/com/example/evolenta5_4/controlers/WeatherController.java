package com.example.evolenta5_4.controlers;

import com.example.evolenta5_4.models.weathers.Main;
import com.example.evolenta5_4.models.weathers.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@EnableScheduling
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${appid}")
    private String appId;
    @Value("${url.weather}")
    private String urlWeather;

    @Cacheable(value = "weather")
    @GetMapping
    public Main getWeather(@RequestParam String lat, @RequestParam String lon)  {
        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s", urlWeather, lat, lon, appId);
        simulateSlowService();
        return restTemplate.getForObject(request, Root.class).getMain();
    }

    private void simulateSlowService() {
        try {
            long time = (long) (5000L);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @CacheEvict(value = "weather",allEntries = true)
    @Scheduled(fixedRate = 60000L)
    public void evict() {
    }
}
