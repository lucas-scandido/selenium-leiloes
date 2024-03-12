import org.junit.jupiter.api.*;

public class LoginTest {
    private LoginPage loginPage;
    private static final String LOGIN = "/login";

    @BeforeEach
    public void beforeEach() {
        this.loginPage = new LoginPage(LOGIN);
    }

    @AfterEach
    public void afterEach() {
        this.loginPage.closeBrowser();
    }

    @Test
    public void shouldLoginWithValidUser() {
        loginPage.fillFormLogin("fulano", "pass");
        loginPage.btnSubmitLogin();

        Assertions.assertFalse(loginPage.loginPageUrl(LOGIN));
        Assertions.assertEquals("fulano", loginPage.getLoggedUserName());
    }

    @Test
    public void shouldNotLoginWithInvalidUser() {
        loginPage.fillFormLogin("beltranho", "pass");
        loginPage.btnSubmitLogin();

        Assertions.assertTrue(loginPage.loginPageUrl("/login?error"));
        Assertions.assertNull(loginPage.getLoggedUserName());
        Assertions.assertTrue(loginPage.shouldHaveText("Usuário e senha inválidos."));
    }

    @Test
    public void shouldNotAccessRestrictedPages() {
        loginPage.goToAuctionPage();

        Assertions.assertTrue(loginPage.loginPageUrl(LOGIN));
        Assertions.assertFalse(loginPage.shouldHaveText("Dados do Leilão"));
    }
}