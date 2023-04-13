package com.tteam.reporter.component.xlsx;

import com.tteam.reporter.pojo.CountryPojo;
import com.tteam.reporter.pojo.GenrePojo;
import com.tteam.reporter.pojo.MoviePojo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorAllMoviesDataTest {

    private final GeneratorAllMoviesData generatorAllMoviesData = new GeneratorAllMoviesData();

    @Test
    @DisplayName("getData_checkCorrectness")
    void testGetData() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("All movies");
        generatorAllMoviesData.getData(workbook, sheet, getData());
        MoviePojo moviePojo = getData().get(0);
        XSSFRow row = sheet.getRow(1);
        assertAll(
                () -> assertEquals(moviePojo.getNameUkr(), getCellValue(row, 0)),
                () -> assertEquals(moviePojo.getNameNative(), getCellValue(row, 1)),
                () -> assertEquals(moviePojo.getYearOfRelease().intValue(), getNumericCellValue(row, 2)),
                () -> assertEquals(moviePojo.getDescription(), getCellValue(row, 3)),
                () -> assertEquals(moviePojo.getPrice(), getNumericCellValue(row, 4)),
                () -> assertEquals(moviePojo.getRating(), getNumericCellValue(row, 5)),

                () -> assertTrue(moviePojo.getCountries().stream()
                        .map(CountryPojo::getName)
                        .toList()
                        .contains(getCellValue(row, 6)
                                .split(",")[0])),

                () -> assertTrue(moviePojo.getGenres().stream()
                        .map(GenrePojo::getName)
                        .toList()
                        .contains(getCellValue(row, 7)
                                .split(",")[0]))
        );
    }

    private List<MoviePojo> getData() {
        Set<CountryPojo> countries1 = Set.of(
                CountryPojo.builder().name("USA").build(),
                CountryPojo.builder().name("Poland").build()
        );
        Set<GenrePojo> genres1 = Set.of(
                GenrePojo.builder().name("drama").build(),
                GenrePojo.builder().name("thriller").build()
        );
        MoviePojo movie1 = MoviePojo.builder()
                .nameUkr("Побег из Шоушенка")
                .nameNative("The Shawshank Redemption")
                .yearOfRelease(1994)
                .description("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.")
                .price(123.45)
                .rating(8.9)
                .countries(countries1)
                .genres(genres1)
                .build();

        Set<CountryPojo> countries2 = Set.of(
                CountryPojo.builder().name("India").build(),
                CountryPojo.builder().name("Norway").build()
        );
        Set<GenrePojo> genres2 = Set.of(
                GenrePojo.builder().name("drama").build(),
                GenrePojo.builder().name("comedy").build(),
                GenrePojo.builder().name("thriller").build()
        );
        MoviePojo movie2 = MoviePojo.builder()
                .nameUkr("1+1")
                .nameNative("Intouchables")
                .yearOfRelease(2011)
                .description("Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, — молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.")
                .price(120.0)
                .rating(8.3)
                .countries(countries2)
                .genres(genres2)
                .build();

        return List.of(movie1, movie2);
    }

    private static String getCellValue(XSSFRow row, int cellNumber) {
        return row.getCell(cellNumber).getStringCellValue();
    }
    private static double getNumericCellValue(XSSFRow row, int cellNumber) {
        return row.getCell(cellNumber).getNumericCellValue();
    }
}