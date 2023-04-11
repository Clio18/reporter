package com.tteam.reporter.fabric;

import com.tteam.reporter.strategy.pdf.PDFReportStrategy;
import com.tteam.reporter.strategy.StrategyName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PDFReportFabric implements ReportFabric{

    private Map<StrategyName, PDFReportStrategy> strategies;

    @Autowired
    public PDFReportFabric(Set<PDFReportStrategy> pdfReportStrategySet) {
        createStrategy(pdfReportStrategySet);
    }

    @Override
    public PDFReportStrategy getStrategy(StrategyName strategy) {
        return strategies.get(strategy);
    }

    private void createStrategy(Set<PDFReportStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach( strategy -> strategies.put( strategy.getStrategyName(), strategy));
    }

    @Override
    public ReportType getReportType() {
        return ReportType.PDF;
    }
}
