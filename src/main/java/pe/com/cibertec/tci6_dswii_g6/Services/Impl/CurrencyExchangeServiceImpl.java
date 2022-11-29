package pe.com.cibertec.tci6_dswii_g6.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.tci6_dswii_g6.Models.CurrencyExchange;
import pe.com.cibertec.tci6_dswii_g6.Repositories.CurrencyExchangeRepository;
import pe.com.cibertec.tci6_dswii_g6.Services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public Integer save(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange).getId();
    }
}
