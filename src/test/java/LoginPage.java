import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends CommonPage{

    private static final String PAGE_URL = "http://localhost:8080";
    public LoginPage(String url) {
        super(null);
        this.browser.navigate().to(PAGE_URL + url);
    }

    public void fillFormLogin(String username, String password){
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    public AuctionPage btnSubmitLogin() {
        this.browser.findElement(By.id("btn-login")).click();
        return new AuctionPage(browser);
    }

    public String getLoggedUserName() {
        try {
            return browser.findElement(By.id("logged-user")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean loginPageUrl(String url){
        return browser.getCurrentUrl().equals(PAGE_URL + url);
    }

    public void goToAuctionPage(){
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean shouldHaveText(String text){
        return browser.getPageSource().contains(text);
    }
}