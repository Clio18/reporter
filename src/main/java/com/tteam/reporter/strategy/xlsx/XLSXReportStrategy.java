package com.tteam.reporter.strategy.xlsx;

import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.ReportStrategy;
import com.tteam.reporter.strategy.StrategyName;

public interface XLSXReportStrategy extends ReportStrategy {
    StrategyName getStrategyName();

    @Override
    ReportResponse generate();
}
