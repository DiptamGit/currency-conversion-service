package com.diptam.controller;

import com.diptam.client.CurrencyExchangeServiceProxy;
import com.diptam.model.CurrencyConverter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Log4j2
public class CurrencyCoversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-conversion-service/from/{from}/to/{to}/amount/{amount}")
    public ResponseEntity<CurrencyConverter> convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount){
        log.info(from+" : "+to+" : "+amount);
        CurrencyConverter converter = proxy.getExchangeRate(from, to);
        log.info("Response : >>>>>>>>>>>>>>>> "+converter);
        return ResponseEntity.ok(new CurrencyConverter(converter.getId(),converter.getCurrency_from(),converter.getCurrency_to(),
                                converter.getConversionMultiple(),amount,
                                amount.multiply(new BigDecimal(converter.getConversionMultiple()))));
    }


}
