package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "HelpdeskBasePage")
public class HelpdeskPage extends WebPage {

    @Name("Выбор очереди")
    private SelenideElement selectQueue = $(By.id("id_queue"));

    @Name("Ввод названия тикета")
    private SelenideElement inputTitle = $(By.id("id_title"));

    @Name("Ввод описания проблемы")
    private SelenideElement inputDescriptionOfIssue = $(By.id("id_body"));

    @Name("Выбор приоритета")
    private SelenideElement selectPriority = $(By.id("id_priority"));

    @Name("Выбор даты окончания")
    private SelenideElement selectDueDate = $(By.id("id_due_date"));

    @Name("Ввод электронной почты")
    private SelenideElement inputEmail = $(By.id("id_submitter_email"));

    @Name("Кнопка создания тикета")
    private SelenideElement submitTicketButton = $x("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/div/div/form/button");

    @Name("Кнопка авторизации")
    private SelenideElement logInButton = $(By.id("userDropdown"));

    @Name("Поиск сохраненного запроса")
    private SelenideElement savedQuery = $(By.id("ticketsDropdown"));

}
