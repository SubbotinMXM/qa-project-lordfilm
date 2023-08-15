package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class MoviePage {
    private final SelenideElement yearOfMovie = $x("//span[@itemprop='dateCreated']");
    private final SelenideElement countryOfMovie = $x("//span[text()='Страна:']//parent::li");
    private final SelenideElement actorsOfMovie = $x("//span[@itemprop='actors']");
    private final SelenideElement kpOfMovie = $x("//ul[@class='flist']//div[@data-text='kp']");
    private final SelenideElement genreOfMovie = $x("//span[@itemprop='genre']");



    public void assertYear(int year){
        int actualYear = Integer.parseInt(yearOfMovie.getText());
        Assertions.assertTrue(actualYear>=year);
    }

    public void assertCountry(String country){
        countryOfMovie.should(Condition.partialText(country));
    }

    public void assertActor(String actor){
        actorsOfMovie.should(Condition.partialText(actor));
    }

    public void assertKP(int kp){
        String rawKP = kpOfMovie.getText().replaceAll("[^0-9.]", "");
        double doubleKP = Double.parseDouble(rawKP);
        int actualKP = (int) doubleKP;
        Assertions.assertTrue(actualKP>=kp);
    }

    public void assertGenre(String genre){
        genreOfMovie.should(Condition.partialText(genre));
    }

}
