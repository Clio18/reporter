package com.tteam.reporter.strategy.xlsx;

import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.StrategyName;
import org.springframework.stereotype.Component;

@Component
public class XLSXAllMoviesReport implements XLSXReportStrategy {
    @Override
    public StrategyName getStrategyName() {
        return StrategyName.ALL_MOVIES;
    }

    @Override
    public ReportResponse generate() {
        //get needed data
        //generate report
        //create ReportResponse
        return null;
    }
}
