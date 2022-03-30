package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class PropertyInitialization {
    public static Properties config;
    public static Properties prop;
    public static Properties browserProp;
    public static final String propertiesPath="/src/main/java/properties/";

    public static void initProperties(){
        try {
            if(config==null) {
                config=new Properties();
                FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+propertiesPath+"config.properties");
                config.load(fs);

                prop=new Properties();
                FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+propertiesPath+config.getProperty("Environment").toLowerCase()+".properties");
                prop.load(ip);
                System.out.println("Environment is set to: "+config.getProperty("Environment").toLowerCase());


            }

            if(browserProp==null){
                browserProp=new Properties();
                FileInputStream bp=new FileInputStream(System.getProperty("user.dir")+propertiesPath+"browser.properties");
                browserProp.load(bp);
            }



            for (Map.Entry entry:config.entrySet())
                System.setProperty((String) entry.getKey(), (String) entry.getValue());

            for (Map.Entry entry:prop.entrySet())
                System.setProperty((String) entry.getKey(), (String) entry.getValue());

            for (Map.Entry entry:browserProp.entrySet())
                System.setProperty((String) entry.getKey(), (String) entry.getValue());




        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();


        }
    }

    public static String getBrowserProperty(String browserProperty) {
        //System.setProperty(browserProperty,browserProp.getProperty(browserProperty));
        return browserProp.getProperty(browserProperty);

    }


    public static String getConfigProperty(String configProperty){
       // System.setProperty(configProperty,config.getProperty(configProperty));
        return config.getProperty(configProperty);
    }

    public static String getEnvironmentProperty(String environmentProperty){
       // System.setProperty(environmentProperty,prop.getProperty(environmentProperty));
        return prop.getProperty(environmentProperty);
    }

}
