package pe.com.cibertec.tci6_dswii_g6.Controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class InicioController {


    @Scheduled(cron = "0 0 * * *")
    public void Scrapping() throws IOException {
        String url="";
        Document webPage=Jsoup.connect(url).get();
        Element table=webPage.getElementsByAttributeValue("data-test","historical-data-table").get(0);
        Element row=table.getElementsByAttributeValue("data-test","historical-data-table-row").get(0);


    }

}
