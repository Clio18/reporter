package com.tteam.reporter.strategy.pdf;

import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.StrategyName;
import org.springframework.stereotype.Component;

@Component
public class PDFPeriodMoviesReport implements PDFReportStrategy {
    @Override
    public StrategyName getStrategyName() {
        return StrategyName.PERIOD_MOVIES;
    }

    @Override
    public ReportResponse generate() {
        //get needed data
        //generate report
        //create ReportResponse
        return null;
    }
}
