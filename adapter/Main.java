package adapter;

public class Main {

    public static void main(String [] args){
        ChromeDriver chromeDriver = new ChromeDriver();
        System.out.println(chromeDriver.getData());

        AnyDriver anyDriver = new AnyDriver();
        System.out.println(anyDriver.getFeed());

        WebDriver webDriverAdapter = new WebDriverAdapter(anyDriver);
        System.out.println(webDriverAdapter.getData());
    }
}
