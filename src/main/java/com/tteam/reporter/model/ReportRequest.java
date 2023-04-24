package com.tteam.reporter.model;

import com.tteam.reporter.fabric.ReportType;
import com.tteam.reporter.strategy.StrategyName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {
    private ReportType type;
    private StrategyName strategy;
}
