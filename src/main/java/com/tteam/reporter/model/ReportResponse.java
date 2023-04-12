package com.tteam.reporter.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

@Builder
@JsonSerialize
@Data
public class ReportResponse {
    private String message;
    private byte[] content;
}
