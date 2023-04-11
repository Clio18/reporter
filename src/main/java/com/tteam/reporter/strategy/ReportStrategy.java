package com.tteam.reporter.strategy;

import com.tteam.reporter.model.ReportResponse;
import org.springframework.stereotype.Component;

public interface ReportStrategy {
    ReportResponse generate();
}
