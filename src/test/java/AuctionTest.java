import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuctionTest {

    private AuctionPage auctionPage;
    private RegisterAuctionPage registerAuctionPage;

    @BeforeEach
    public void beforeEach(){
        LoginPage loginPage = new LoginPage("/login");
        loginPage.fillFormLogin("fulano", "pass");
        this.auctionPage = loginPage.btnSubmitLogin();
        this.registerAuctionPage = auctionPage.btnNewAuction();
    }

    @AfterEach
    public void afterEach(){
        this.auctionPage.closeBrowser();
    }

    @Test
    public void registerAuction(){
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String name = "Leilão do dia " + date;
        String value = "500.00";

        this.auctionPage = registerAuctionPage.registerNewAuction(name, value, date);
        Assertions.assertTrue(auctionPage.validateAuction(name, value, date));
        Assertions.assertTrue(auctionPage.successMessage("Leilão salvo com sucesso"));

    }

    @Test
    public void validateErrorMessages(){
        this.auctionPage = registerAuctionPage.registerNewAuction("", "", "");

        Assertions.assertFalse(this.registerAuctionPage.verifyPage());
        Assertions.assertTrue(this.registerAuctionPage.errorMessages());
    }
}
