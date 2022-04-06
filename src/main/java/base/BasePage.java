package base;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class BasePage {

    private static ThreadLocal<Page> page=new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browser=new ThreadLocal<>();

    public static BrowserContext getBrowserContext(){
        if(browser.get()==null){
        Playwright playwright=Playwright.create();

        Browser browserInstance = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browser.set(browserInstance.newContext());}
                 return browser.get();

    }

    public static Page getPage(){
        if(page.get()==null){
            page.set(getBrowserContext().newPage());
        }
        return page.get();
    }

    public static void closeBrowser(){
        page.get().close();
        page.set(null);
    }

    public static void startTracing(){
        getBrowserContext().tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
    }

    public static void stopTracing(){
        getBrowserContext().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }


}
