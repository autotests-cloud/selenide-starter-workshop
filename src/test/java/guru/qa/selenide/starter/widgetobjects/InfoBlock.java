package guru.qa.selenide.starter.widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class InfoBlock {

  SelenideElement button;

 public InfoBlock(String selector){
   $(selector).$("button");
 }
  // element
  public SelenideElement text= $("div");
  SelenideElement image= $("img");
  SelenideElement button2= $("button");


  // methods
  public void getDetails(){
    //getByTitle(nameOfDeposit).$("button").click();
    button.click();
  }

  public SelenideElement getByTitle(String nameOfDeposit){
    return $("#filter").find(Selectors.byText(nameOfDeposit)).closest(".m23QzrO");
  }
}
