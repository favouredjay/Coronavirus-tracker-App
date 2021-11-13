package com.covidTracker.coronavirustracker.controller;

import com.covidTracker.coronavirustracker.models.LocationStats;
import com.covidTracker.coronavirustracker.service.CoronaVirusDataServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataServiceImpl coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
//        model.addAttribute("locationStats", coronaVirusDataService.getStats());
//        return "home";
        List<LocationStats> allStats = coronaVirusDataService.getStats();
        int totalReportedCases = allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDifference()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
