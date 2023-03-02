package utils;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.Cookie;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommonUtils extends BasePage{

    public static void openUrl(String url){
        getPage().navigate(url);
    }

    public static void clickButton(String locator){
        getPage().click(locator);
    }

    public static void getText(String locator){
        getPage().textContent(locator);
    }

    public static void clickFirstElement(String locator){
        getPage().locator(locator).first().click();
    }

    public static int getLocatorCount(String locator){
        return getPage().locator(locator).count();
    }

    public static List<String> getTableDataList(String tableLocator){
        return getPage().locator(tableLocator).allTextContents();
    }

    public static void enterText(String text,String locator){
        getPage().fill(locator,text);
    }

    public static Map<Integer,List<String>> getTableDataMap(String tableLocator){
        Map<Integer,List<String>> dataMap=new LinkedHashMap<>();
        List<String> dataList=new ArrayList<>();
        int rows=getPage().locator(tableLocator).count();
        Locator rowLocator=getPage().locator(tableLocator);
        for(int i=1;i<=rows;i++){
            dataList.addAll(getPage().locator(tableLocator).allTextContents());
            dataMap.put(i,dataList);
        }
        return dataMap;
    }

    public static void hoverAndClickLocator(String locator){
        getPage().locator(locator).hover();
        getPage().locator(locator).click();
    }

    public static void verifyText(String expectedText,String locatorToExtractActualText){
        assertEquals(getPage().textContent(locatorToExtractActualText),expectedText);
    }

    public static void verifyCheckBoxIsSelected(String locator){
        assertTrue(getPage().isChecked(locator));
    }

    public static void verifyVisibilityOfLocator(String locator){
        assertTrue(getPage().isVisible(locator));
    }

    public static void verifyEnableStateOfLocator(String locator){
        assertTrue(getPage().isEnabled(locator));
    }

    public static void verifyElementIsEditable(String locator){
        assertTrue(getPage().locator(locator).isEditable());
    }

    public static void verifyElementIsDisabled(String locator){
        assertTrue(getPage().locator(locator).isDisabled());
    }

    public static void addCookies(Cookie cookie){
        BasePage.getBrowserContext().addCookies(Arrays.asList(cookie));
    }

    public static int generateRandomNumber(int size){
        return new Random().nextInt(size);
    }










}
