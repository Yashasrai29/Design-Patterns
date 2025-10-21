package adapter;

public class WebDriverAdapter implements WebDriver{

    private AnyDriver driver;
    public WebDriverAdapter(AnyDriver driver){
        this.driver = driver;
    }

    @Override
    public String getData() {
        return driver.getFeed();
    }
}
