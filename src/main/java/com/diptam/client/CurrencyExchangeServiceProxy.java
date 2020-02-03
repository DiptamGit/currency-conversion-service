package com.diptam.client;

import com.diptam.model.CurrencyConverter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

   // @GetMapping("/currency-exchange/from/{from}/to/{to}")
    //public CurrencyConverter getExchangeRate(@PathVariable String from, @PathVariable String to);

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConverter getExchangeRate(@PathVariable String from, @PathVariable String to);
}