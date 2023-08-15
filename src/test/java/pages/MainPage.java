package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement movieButton = $x("//a[@class='logo']//following::a[1]");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public FilterPage clickOnMovieButton (){
        movieButton.click();
        return new FilterPage();
    }

}
