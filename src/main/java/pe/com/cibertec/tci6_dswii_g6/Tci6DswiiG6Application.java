package pe.com.cibertec.tci6_dswii_g6;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class Tci6DswiiG6Application {

    public static void main(String[] args) {
        SpringApplication.run(Tci6DswiiG6Application.class, args);
    }

}
