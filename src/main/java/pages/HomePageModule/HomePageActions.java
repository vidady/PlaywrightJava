package pages.HomePageModule;

import base.BasePage;
import utils.CommonUtils;

public class HomePageActions extends BasePage implements HomePageLocators {




    public void checkHeaderLinksNavigation(){
        CommonUtils.clickButton(mobileHeaderLink);
        CommonUtils.clickButton(primeHeaderLink);
        CommonUtils.clickButton(booksHeaderLink);
    }

    public void printTitleAndUrl(){
        System.out.println("title: "+getPage().title());
        System.out.println("url "+getPage().url());
    }

}
