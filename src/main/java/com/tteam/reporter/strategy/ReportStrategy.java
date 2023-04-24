package com.tteam.reporter.strategy;

import com.tteam.reporter.model.ReportResponse;
import java.util.List;

public interface ReportStrategy {
    ReportResponse generate(List<?> entities);
}
