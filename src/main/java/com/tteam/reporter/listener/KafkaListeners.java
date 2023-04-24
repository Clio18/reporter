package com.tteam.reporter.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tteam.reporter.model.Report;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.pojo.MoviePojo;
import com.tteam.reporter.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeners {
    private final ReportService reportService;
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "allMovies", groupId = "group_one")
    void listenerMovies(String report) throws JsonProcessingException {
        Report<MoviePojo> allMoviesReport = mapper.readValue(report, new TypeReference<>() {});
        ReportResponse reportResponse = reportService.buildReport(allMoviesReport);
        kafkaTemplate.send("allMoviesRequest", reportResponse.getContent());
    }
}