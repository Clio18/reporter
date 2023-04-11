package com.tteam.reporter.fabric;

import com.tteam.reporter.strategy.StrategyName;
import com.tteam.reporter.strategy.xlsx.XLSXReportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class XLSXReportFabric implements ReportFabric {
    private Map<StrategyName, XLSXReportStrategy> strategies;

    @Autowired
    public XLSXReportFabric(Set<XLSXReportStrategy> xlsxReportStrategySet) {
        createStrategy(xlsxReportStrategySet);
    }

    @Override
    public XLSXReportStrategy getStrategy(StrategyName strategy) {
        return strategies.get(strategy);
    }

    private void createStrategy(Set<XLSXReportStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach( strategy -> strategies.put( strategy.getStrategyName(), strategy));
    }

    @Override
    public ReportType getReportType() {
        return ReportType.XLSX;
    }
}
