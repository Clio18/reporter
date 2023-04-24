package com.tteam.reporter.strategy.xlsx;

import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.ReportStrategy;
import com.tteam.reporter.strategy.StrategyName;

import java.util.List;

public interface XLSXReportStrategy extends ReportStrategy {
    StrategyName getStrategyName();

    @Override
    ReportResponse generate(List<?> entities);
}
