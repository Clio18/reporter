package com.tteam.reporter.strategy.xlsx;

import com.tteam.reporter.component.xlsx.GeneratorAllMoviesSheet;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.pojo.MoviePojo;
import com.tteam.reporter.strategy.StrategyName;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class XLSXAllMoviesReport implements XLSXReportStrategy {
    private final GeneratorAllMoviesSheet generatorAllMoviesSheet;
    @Override
    public StrategyName getStrategyName() {
        return StrategyName.ALL_MOVIES;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ReportResponse generate(List<?> entities) {
        //generate report
        XSSFWorkbook workbook = new XSSFWorkbook();
        List<MoviePojo> movies = (List<MoviePojo>) entities;
        generatorAllMoviesSheet.getAllMovies(workbook, "All_movies", movies);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //create ReportResponse
        byte[] bytes = bos.toByteArray();
        return ReportResponse.builder()
                .message("Report All movies")
                .content(bytes)
                .build();
    }
}
