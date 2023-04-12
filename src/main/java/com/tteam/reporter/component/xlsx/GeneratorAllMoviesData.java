package com.tteam.reporter.component.xlsx;

import com.tteam.reporter.pojo.CountryPojo;
import com.tteam.reporter.pojo.GenrePojo;
import com.tteam.reporter.pojo.MoviePojo;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeneratorAllMoviesData {
    private static final String NUMBER_FORMAT = "#,##0.00";

    public void getData(XSSFWorkbook workbook, XSSFSheet sheet, List<MoviePojo> moviePojoList) {
        CellStyle numericStyle = ReportStyle.getValuesStyle(workbook);
        numericStyle.setDataFormat(workbook.createDataFormat().getFormat(NUMBER_FORMAT));

        CellStyle textStyle = ReportStyle.getValuesStyle(workbook);

        int rowNum = 1;
        for (MoviePojo pojo : moviePojoList) {
            XSSFRow row = sheet.createRow(rowNum);
            ReportStyle.createCell(row, 0, pojo.getNameUkr(), textStyle);
            ReportStyle.createCell(row, 1, pojo.getNameNative(), textStyle);
            ReportStyle.createCell(row, 2, pojo.getYearOfRelease(), textStyle);
            ReportStyle.createCell(row, 3, pojo.getDescription(), textStyle);

            ReportStyle.createCell(row, 4, pojo.getPrice(), numericStyle);
            ReportStyle.createCell(row, 5, pojo.getRating(), numericStyle);

            String countries = pojo.getCountries().stream()
                    .map(CountryPojo::getName)
                    .collect(Collectors.joining(", "));
            ReportStyle.createCell(row, 6, countries, textStyle);

            String genres = pojo.getGenres().stream()
                    .map(GenrePojo::getName)
                    .collect(Collectors.joining(", "));
            ReportStyle.createCell(row, 7, genres, textStyle);
            rowNum++;
        }
    }
}
