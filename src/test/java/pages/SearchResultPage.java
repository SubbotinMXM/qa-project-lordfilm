package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultPage {
    private final ElementsCollection foundCards = $$x("//div[@class='th-item']/a/div[4]");

    public MoviePage clickOnCard(){
        foundCards.should(CollectionCondition.sizeGreaterThanOrEqual(1)).get(1)
                .should(Condition.interactable).click();
        return new MoviePage();
    }
}
