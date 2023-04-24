package com.tteam.reporter.strategy.pdf;

import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.ReportStrategy;
import com.tteam.reporter.strategy.StrategyName;

import java.util.List;

public interface PDFReportStrategy extends ReportStrategy {

    StrategyName getStrategyName();

    @Override
    ReportResponse generate(List<?> entities);
}
