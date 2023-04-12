package com.tteam.reporter.controller;

import com.tteam.reporter.model.ReportRequest;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//FOR TESTING
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    public static final String HEADER_ATTACH = "attachment; filename=\"";

    private final ReportService reportService;

    @PostMapping
    protected ResponseEntity<byte[]> getReport(@RequestBody ReportRequest request){
        ReportResponse reportResponse = reportService.buildReport(request);
        String filename = String.format("All_movies_report_%s.xlsx", LocalDate.now());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, HEADER_ATTACH + filename + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                //FIXME:
                .body(reportResponse.getContent());
    }
}
