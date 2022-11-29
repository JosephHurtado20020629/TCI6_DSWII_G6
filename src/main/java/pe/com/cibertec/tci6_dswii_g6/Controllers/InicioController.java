package pe.com.cibertec.tci6_dswii_g6.Controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.cibertec.tci6_dswii_g6.Models.CurrencyExchange;
import pe.com.cibertec.tci6_dswii_g6.Services.CurrencyExchangeService;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Controller
public class InicioController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @Scheduled(cron = "0 0 * * * *")
    public void Scrapping() throws IOException, ParseException {
        String url = "https://es.investing.com/currencies/usd-pen-historical-data";
        Document webPage = Jsoup.connect(url).get();
        Element table = webPage.getElementsByAttributeValue("data-test", "historical-data-table").get(0);
        Element row = table.getElementsByAttributeValue("data-test", "historical-data-table-row").get(0);
        String date = row.getElementsByTag("td").get(0).getElementsByTag("time").get(0).text();
        Double lastValue = convert(row.getElementsByTag("td").get(1).text());
        Double fistValue = convert(row.getElementsByTag("td").get(2).text());
        Double maxValue = convert(row.getElementsByTag("td").get(3).text());
        Double minValue = convert(row.getElementsByTag("td").get(4).text());
        System.out.println(new CurrencyExchange(date, lastValue, fistValue, maxValue, minValue).toString());
        currencyExchangeService.save(new CurrencyExchange(date, lastValue, fistValue, maxValue, minValue));
    }

    private Double convert(String val) throws ParseException {
        String valpoint=val.replace(",",".");
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        return nf.parse(valpoint).doubleValue();
    }


    @GetMapping
    public String index(){
        return "index";
    }



}
