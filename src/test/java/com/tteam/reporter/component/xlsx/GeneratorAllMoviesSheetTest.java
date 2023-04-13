package com.tteam.reporter.component.xlsx;

import com.tteam.reporter.pojo.MoviePojo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

@WebMvcTest(GeneratorAllMoviesData.class)
class GeneratorAllMoviesSheetTest {
    @Mock
    private GeneratorAllMoviesData generatorAllMoviesData;

    @InjectMocks
    private GeneratorAllMoviesSheet generatorAllMoviesSheet;

    private XSSFSheet sheet;

    private final List<MoviePojo> moviePojoList = new ArrayList<>(1);

    @Test
    @DisplayName("getGetAllMoviesHeader_checkCorrectness")
    void testGetAllMovies() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        String allMovies = "All movies";
        doNothing().when(generatorAllMoviesData).getData(workbook,sheet, moviePojoList);
        //build the sheet
        generatorAllMoviesSheet.getAllMovies(workbook, allMovies, moviePojoList);
        XSSFSheet sheet = workbook.getSheet(allMovies);
        //check headers
        XSSFRow row = sheet.getRow(0);
        assertAll(
                () -> assertEquals("Name Ukr", getCellValue(row, 0)),
                () -> assertEquals("Name Native", getCellValue(row, 1)),
                () -> assertEquals("Year of Release", getCellValue(row, 2)),
                () -> assertEquals("Description", getCellValue(row, 3)),
                () -> assertEquals("Price", getCellValue(row, 4)),
                () -> assertEquals("Rating", getCellValue(row, 5)),
                () -> assertEquals("Countries", getCellValue(row, 6)),
                () -> assertEquals("Genres", getCellValue(row, 7))
        );
    }

    private static String getCellValue(XSSFRow row, int cellNumber) {
        return row.getCell(cellNumber).getStringCellValue();
    }
}