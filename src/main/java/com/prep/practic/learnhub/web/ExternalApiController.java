package com.prep.practic.learnhub.web;

import com.prep.practic.learnhub.dto.BinancePrice;
import com.prep.practic.learnhub.dto.GitHubUser;
import com.prep.practic.learnhub.dto.WeatherResponse;
import com.prep.practic.learnhub.email.AsyncEmailService;
import com.prep.practic.learnhub.email.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {


    public ExternalApiController() {

    }

    @GetMapping("/github")
    public ResponseEntity<String> getGithubUser() {
        try {
            GitHubUser user = new RestTemplate().getForObject(
                    "https://api.github.com/users/octocat", GitHubUser.class);

            System.out.println(user);
            WebClient client = WebClient.create("https://api.github.com");
            user = client.get()
                    .uri("/users/octocat")
                    .retrieve()
                    .bodyToMono(GitHubUser.class)
                    .block();

            System.out.println(user);
            return ResponseEntity.ok("got user");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("wtf?");
        }
    }

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather() {
        try {
            WeatherResponse weather = new RestTemplate().getForObject(
                    "https://api.openweathermap.org/data/2.5/weather?q=London&appid=85147c9cacd3649830cf6439e434e896", WeatherResponse.class);

            System.out.println(weather);
            WebClient client = WebClient.create("https://api.openweathermap.org");
            weather = client.get()
                    .uri("/data/2.5/weather?q=London&appid=85147c9cacd3649830cf6439e434e896")
                    .retrieve()
                    .bodyToMono(WeatherResponse.class)
                    .block();

            System.out.println(weather);
            return ResponseEntity.ok("got weather");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("wtf?");
        }
    }

    @GetMapping("/binance")
    public ResponseEntity<String> getBinance() {
        try {
            BinancePrice binancePrice = new RestTemplate().getForObject(
                    "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT", BinancePrice.class);

            System.out.println(binancePrice);
            WebClient client = WebClient.create("https://api.binance.com");
            binancePrice = client.get()
                    .uri("/api/v3/ticker/price?symbol=BTCUSDT")
                    .retrieve()
                    .bodyToMono(BinancePrice.class)
                    .block();

            System.out.println(binancePrice);
            return ResponseEntity.ok("got binance");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("wtf?");
        }
    }
}
