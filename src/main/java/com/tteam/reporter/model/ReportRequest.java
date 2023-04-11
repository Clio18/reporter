package com.tteam.reporter.model;

import com.tteam.reporter.fabric.ReportType;
import com.tteam.reporter.strategy.StrategyName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReportRequest {
    private ReportType type;
    private StrategyName strategy;
}
