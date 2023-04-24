package com.tteam.reporter.model;

import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report<E> {
    private ReportRequest reportRequest;
    private List<E> entityList;
}