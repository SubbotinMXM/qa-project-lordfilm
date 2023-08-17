package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FilterPage {
    private final SelenideElement genreButton = $x("//span[text()='Любой жанр']");
    private final SelenideElement countryButton = $x("//span[text()='Любая страна']");
    private final SelenideElement yearSlider = $x("//input[@id='year']//preceding::span[2]");
    private final SelenideElement kpSlider = $x("//input[@id='kp']//preceding::span[2]");
    private final SelenideElement actorSearchField = $x("//input[@name='actors']");
    private final SelenideElement searchButton = $x("//input[@value='Поиск']");
    private final ElementsCollection filterElements = $$x("//li[@class='active-result']");


    public FilterPage chooseGenre(String genre){
        genreButton.click();
        filterElements.find(Condition.partialText(genre)).click();
        return this;
    }

    public FilterPage chooseCountry(String country){
        countryButton.click();
        filterElements.find(Condition.partialText(country)).click();
        return this;
    }

    public FilterPage chooseYear(){
        yearSlider.should(Condition.interactable).click();
        Selenide.actions().dragAndDropBy(yearSlider, 148, 0).build().perform();
        return this;
    }

    public FilterPage chooseKP(){
        kpSlider.should(Condition.interactable).click();
        Selenide.actions().dragAndDropBy(kpSlider, 140, 0).build().perform();
        return this;
    }

    public FilterPage typeName(String name){
        actorSearchField.sendKeys(name);
        return this;
    }

    public SearchResultPage clickSearchButton(){
        searchButton.click();
        searchButton.should(Condition.disappear);
        return new SearchResultPage();
    }

    public FilterPage(){
        searchButton.should(Condition.interactable);
    }
}

