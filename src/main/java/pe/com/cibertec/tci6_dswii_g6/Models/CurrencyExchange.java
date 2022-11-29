package pe.com.cibertec.tci6_dswii_g6.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_currency_exchange")
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private Double lastValue;

    private Double firstValue;

    private Double maxValue;

    private Double minValue;

    public CurrencyExchange(String date,Double lastValue,Double firstValue,Double maxValue,Double minValue){
        this.date= date;
        this.lastValue =lastValue;
        this.firstValue=firstValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public CurrencyExchange() {

    }
}
