package com.tteam.reporter.service;

import com.tteam.reporter.fabric.ReportFabric;
import com.tteam.reporter.handler.ReportHandler;
import com.tteam.reporter.model.ReportRequest;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.strategy.ReportStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportHandler handler;

    public ReportResponse buildReport(ReportRequest request){
        //get report type
        ReportFabric reportFabric = handler.getReportFabric(request.getType());
        //get report type content
        ReportStrategy strategy = reportFabric.getStrategy(request.getStrategy());
        //generate report
        return strategy.generate();
    }
}
