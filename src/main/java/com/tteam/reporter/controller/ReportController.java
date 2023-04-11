package com.tteam.reporter.controller;

import com.tteam.reporter.model.ReportRequest;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//FOR TESTING
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    protected ResponseEntity<ReportResponse> getReport(){
        ReportResponse reportResponse = reportService.buildReport(ReportRequest.builder().build());
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(reportResponse);
    }
}
