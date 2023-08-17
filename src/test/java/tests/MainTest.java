package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.MoviePage;

public class MainTest {
    private final static String BASE_URL = "https://h1.lordfilm.film/";
    @Test
    public void shouldFiltersWorkCorrect() {
        String expectedActorName = "Киану Ривз";
        String expectedCountry = "США";
        String expectedGenre = "Боевик";
        int expectedKP = 7;
        int expectedYear = 2000;

        MainPage mainPage = new MainPage(BASE_URL);
        MoviePage moviePage = mainPage
                .clickOnMovieButton()
                .chooseKP()
                .chooseYear()
                .chooseGenre(expectedGenre)
                .chooseCountry(expectedCountry)
                .typeName(expectedActorName)
                .clickSearchButton()
                .clickOnCard();

        moviePage.assertActor(expectedActorName);
        moviePage.assertCountry(expectedCountry);
        moviePage.assertGenre(expectedGenre);
        moviePage.assertKP(expectedKP);
        moviePage.assertYear(expectedYear);

    }
}
