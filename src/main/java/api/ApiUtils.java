package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class ApiUtils {

    private Playwright playwright;
    private APIRequestContext request;
    private Map<String,String> headers;
    private APIResponse response;
    public static String baseUrl;

    public void setHeaders(Map<String,String> headersSet){
        headers=new HashMap<>();
        headers.putAll(headersSet);

    }

    public Map<String,String> getHeaders(){
        return headers;
    }
    // USE IN BEFORE ALL
    public void createApiRequestContext(Map<String,String>... headers){
        setHeaders(headers[0]);
        request = playwright.request().newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl).setExtraHTTPHeaders(getHeaders()));

    }

    // USER IN AFTER ALL
    public void disposeApiRequestContext(){
        if(request!=null){
            request.dispose();
            request=null;
        }
    }

    public APIResponse getPostResponse(String postUrl){
        APIResponse response=request.post(postUrl);
        Assert.assertTrue(response.ok());
        this.response=response;
        return response;
    }

    public APIResponse getGetResponse(String getUrl){
        APIResponse response=request.get(getUrl);
        Assert.assertTrue(response.ok());
        this.response=response;
        return response;
    }

    public String getJsonObject(String jsonObject){
        JsonArray json = new Gson().fromJson(this.response.text(), JsonArray.class);
        JsonObject object=null;
        for(JsonElement element:json){
            JsonObject itemObj= element.getAsJsonObject();
            if(!itemObj.has(jsonObject)){
                continue;
            }else{
               object = itemObj;
               break;
            }
        }
        return object.getAsString();
    }



}
