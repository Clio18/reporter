package com.tteam.reporter.strategy.xlsx;

import com.tteam.reporter.component.xlsx.GeneratorAllMoviesSheet;
import com.tteam.reporter.model.ReportResponse;
import com.tteam.reporter.pojo.CountryPojo;
import com.tteam.reporter.pojo.GenrePojo;
import com.tteam.reporter.pojo.MoviePojo;
import com.tteam.reporter.strategy.StrategyName;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class XLSXAllMoviesReport implements XLSXReportStrategy {
    private final GeneratorAllMoviesSheet generatorAllMoviesSheet;
    @Override
    public StrategyName getStrategyName() {
        return StrategyName.ALL_MOVIES;
    }

    @Override
    public ReportResponse generate() {
        //get needed data
        List<MoviePojo> data = getData();
        //generate report
        XSSFWorkbook workbook = new XSSFWorkbook();
        generatorAllMoviesSheet.getAllMovies(workbook, "All_movies", data);
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

    //MOCK DATA
    private List<MoviePojo> getData(){
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
}
