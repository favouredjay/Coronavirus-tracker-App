package com.covidTracker.coronavirustracker.service;

import java.io.IOException;

public interface CoronaVirusDataService {

    public void fetchData() throws IOException, InterruptedException;
}
