import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuctionPage extends CommonPage{

    private static final String AUCTION_URL = "http://localhost:8080/leiloes/new";

    public AuctionPage(WebDriver browser) {
        super(browser);
    }

    public RegisterAuctionPage btnNewAuction() {
        this.browser.navigate().to(AUCTION_URL);
        return new RegisterAuctionPage(browser);
    }

    public boolean validateAuction(String name, String value, String date) {
        WebElement tableLine = this.browser.findElement(By.cssSelector("#auction-table tbody tr:last-child"));
        WebElement columnName = tableLine.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement columnDate = tableLine.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement columnValue = tableLine.findElement(By.cssSelector("td:nth-child(3)"));

        return columnName.getText().equals(name)
                && columnDate.getText().equals(date)
                && columnValue.getText().equals(value);
    }

    public boolean successMessage(String text){
        return browser.getPageSource().contains(text);
    }
}