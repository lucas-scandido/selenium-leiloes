import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAuctionPage extends CommonPage{

    private static final String AUCTION_URL = "http://localhost:8080/leiloes/new";

    public RegisterAuctionPage(WebDriver browser) {
        super(browser);
    }

    public AuctionPage registerNewAuction(String name, String initialValue, String openingDate) {
        this.browser.findElement(By.id("nome")).sendKeys(name);
        this.browser.findElement(By.id("valorInicial")).sendKeys(initialValue);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(openingDate);
        this.browser.findElement(By.id("button-submit")).click();

        return new AuctionPage(browser);
    }

    public boolean verifyPage() {
        return browser.getCurrentUrl().equals(AUCTION_URL);
    }

    public boolean errorMessages() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("não deve estar em branco")
                && pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");

    }
}