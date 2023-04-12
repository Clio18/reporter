package com.tteam.reporter.component.xlsx;

import com.tteam.reporter.pojo.MoviePojo;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GeneratorAllMoviesSheet {
    private final GeneratorAllMoviesData generatorAllMoviesData;

    public void getAllMovies(XSSFWorkbook workbook, String sheetName, List<MoviePojo> moviePojoList) {

        XSSFSheet sheet = workbook.createSheet(sheetName);
        //build the sheet
        XSSFRow row = sheet.createRow(0);
        ReportStyle.createCell(row, 0, "Name Ukr", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 1, "Name Native", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 2, "Year of Release", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 3, "Description", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 4, "Price", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 5, "Rating", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 6, "Countries", ReportStyle.getHeaderStyle(workbook));
        ReportStyle.createCell(row, 7, "Genres", ReportStyle.getHeaderStyle(workbook));

        generatorAllMoviesData.getData(workbook, sheet, moviePojoList);

        sheet.setAutoFilter(new CellRangeAddress(0, sheet.getLastRowNum(), 0, 7));

        for (int i = 0; i <= 7; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}
