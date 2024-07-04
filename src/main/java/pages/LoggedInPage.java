package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends BasePage {
    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"loop-container\"]/div/article/div[1]/h1")
    private WebElement loggedInLabel;

    public String getLoggedInLabel() {
        return loggedInLabel.getText();
    }
}
