package pages.actions;

import BasePage.BasePage;
import pages.locators.HomePageLocators;
import utils.CommonUtils;

public class HomePageActions extends BasePage {




    public void checkHeaderLinksNavigation(){
        CommonUtils.clickButton(HomePageLocators.mobileHeaderLink);
        CommonUtils.clickButton(HomePageLocators.primeHeaderLink);
        CommonUtils.clickButton(HomePageLocators.booksHeaderLink);
    }

    public void printTitleAndUrl(){
        System.out.println("title: "+getPage().title());
        System.out.println("url "+getPage().url());
    }

}
