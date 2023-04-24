package com.tteam.reporter.strategy.pdf;

import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.StrategyName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PDFAllMoviesReport implements PDFReportStrategy {
    @Override
    public StrategyName getStrategyName() {
        return StrategyName.ALL_MOVIES;
    }

    @Override
    public ReportResponse generate(List<?> entities) {
        //get needed data
        //generate report
        //create ReportResponse
        return null;
    }
}
