package com.yuwenl.personalwebsite.scheduler;

import com.yuwenl.personalwebsite.service.CurrencyScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CurrencyScrapingScheduler {

    @Autowired
    private CurrencyScrapingService currencyScrapingService;

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleCurrencyRateFetching() {
        System.out.println("执行定时任务：抓取汇率数据");
        currencyScrapingService.fetchAndSaveCADRates();
        System.out.println("执行定时任务：抓取美元汇率数据");
        currencyScrapingService.fetchAndSaveUSDRates();
    }
}
