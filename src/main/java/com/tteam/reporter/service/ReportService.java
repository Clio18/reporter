package com.tteam.reporter.service;

import com.tteam.reporter.fabric.ReportFabric;
import com.tteam.reporter.handler.ReportHandler;
import com.tteam.reporter.model.Report;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.ReportStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportHandler handler;

    public ReportResponse buildReport(Report<?> report){
        //get report type
        ReportFabric reportFabric = handler.getReportFabric(report.getReportRequest().getType());
        //get report type content
        ReportStrategy strategy = reportFabric.getStrategy(report.getReportRequest().getStrategy());
        //generate report
        return strategy.generate(report.getEntityList());
    }
}
