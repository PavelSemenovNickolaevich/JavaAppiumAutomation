package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testCancelSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }


    @Test
    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject =SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park discography";
        SearchPageObject.typeSearchLine(search_line);

        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );

    }

    @Test
    public void testAmountOfEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        String search_line = "bdrgergbewv";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultsOfSearch();

    }

    @Test
    public void testWithTwoSubStrings() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");

    }

    @Test
    public void testSearchAnyWords() {
        String word = "Hello";
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(word);
        List<WebElement> title = SearchPageObject.listOfElements(By.id("org.wikipedia:id/page_list_item_title"), "List is empty", 5);
//        if (title.size() >= 3) {
//            for(int i = 0; i < 3; i++) {
//                assertEquals(true, title.get(i).getText().contains(word));
//            }
//        }
        IntStream.rangeClosed(0, 2).forEach(i -> assertTrue(title.get(i).getText().contains(word)));
    }
}



/**
 1)Установить XCode
 2)Установить Java
 3)скачать Appium Desktop
 4)Скачать - запустить app
 5)Установить через скрипты зависимости
 6)Открыть проект в икскод и запустить в симуляторе
 7)Подключить appium к проекту, устанвоить необходимые капабилитес
 platformName  text  iOS
 platformVersion text 13.3
 deviceName text iPhone SE
 app text  ../..полный путь к приложению
 */