package com.tteam.reporter.handler;

import com.tteam.reporter.fabric.ReportFabric;
import com.tteam.reporter.fabric.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class ReportHandler {
    private Map<ReportType, ReportFabric> fabrics;

    @Autowired
    public ReportHandler(Set<ReportFabric> fabricSet) {
        createFabric(fabricSet);
    }

    public ReportFabric getReportFabric(ReportType reportType){
        return fabrics.get(reportType);
    }

    private void createFabric(Set<ReportFabric> fabricSet) {
        fabrics = new HashMap<>();
        fabricSet.forEach(fabric -> fabrics.put(fabric.getReportType(), fabric));
    }
}
