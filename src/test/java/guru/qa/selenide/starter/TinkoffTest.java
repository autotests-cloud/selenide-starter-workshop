package guru.qa.selenide.starter;

import com.codeborne.selenide.*;
import guru.qa.selenide.starter.widgetobjects.InfoBlock;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TinkoffTest {

  @Test
  void checkDeposits(){


    open("https://tinkoff.ru");
    $(byText("Вклады")).closest("a").click();

    // Домашнее задание: надёжно заполнить поле, чтобы значение осталось после нажатие таба
    $("[data-qa-type='uikit/inputBox.inputContainer'] input").setValue("1500000"); //.pressTab();
    //actions().sendKeys(Keys.TAB).perform();

    $("[data-qa-type='uikit/inputBox.inputContainer'] input").shouldHave(Condition.value("1500000"));
    $("[data-qa-type='uikit/inputBox']",2).click();
    $("[data-qa-type='uikit/scroll']").$(byText("Евро")).click();
    $("[data-qa-type='uikit/inputBox']",2).$("[data-qa-type='uikit/select.value']").shouldHave(text("Евро"));
    $("div[data-qa-file=Pie]").shouldHave(textCaseSensitive("ЗА 24 МЕСЯЦА Я НАКОПЛЮ"));
    $("div[data-qa-file=Pie]").hover();
    $("div[data-qa-file=Pie]").shouldHave(text("пополнения"));



    //Домашнее задание: доделать проверку чекбокса
    $("div TODO").click();
    $("TODO input[type=checkbox]").shouldBe(checked);


    // arrange
    // act
    // assert
    // act
    // assert
    // act
    // assert

  }

  @Test
  void asserts(){

    String webtoken="";
    open("site.com/404.html");
    WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("webtoken",webtoken));
    open("site.com");

    Configuration.headless=true;

    open("http://","dad","ad","asd");
    $("div").shouldBe(visible);
    String text= $("div").getText();

    int number=$$("div").size();
    $("#filter").$$("[data-widget-name=CatalogCard]").shouldHaveSize(5);

    $$(withText("Побед"));

    new InfoBlock("#pobedaplus").getDetails();


/*
    new DepositsMenu().chooseOnlineOrder("Ипотека");
    new DepositsMenu().startSearch();
    new DepositsMenu().goToOnlineBanking();
*/

    Selenide.closeWebDriver();
  }


}
