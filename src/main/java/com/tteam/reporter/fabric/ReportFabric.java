package com.tteam.reporter.fabric;

import com.tteam.reporter.strategy.ReportStrategy;
import com.tteam.reporter.strategy.StrategyName;

public interface ReportFabric {
    ReportType getReportType();
    ReportStrategy getStrategy(StrategyName name);

}
