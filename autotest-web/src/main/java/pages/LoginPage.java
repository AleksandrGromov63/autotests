package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "LoginPage")
public class LoginPage extends WebPage {

    @Name("Ввод имени")
    private SelenideElement inputUsername = $(By.id("username"));

    @Name("Ввод пароля")
    private SelenideElement inputPassword = $(By.id("password"));

    @Name("Кнопка логина")
    private SelenideElement loginButton = $x("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]");
}
