package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "TicketPage")
public class TicketPage extends WebPage {

    @Name("Поле коммента")
    private SelenideElement inputComment = $(By.id("commentBox"));

    @Name("Выбор статуса")
    private SelenideElement inputStatus = $(By.id("st_closed"));

    @Name("Выбор приоритета")
    private SelenideElement selectPriority = $(By.id("id_priority"));

    @Name("Кнопка прикрепления файла")
    private SelenideElement attachFileButton = $(By.id("ShowFileUpload"));

    @Name("Кнопка выбора файла")
    private SelenideElement browseLabel = $x("//*[@id=\"FileUpload\"]/dl/dd/div/div/label");

    @Name("Выбранный файл")
    private SelenideElement selectedFile = $(By.id("selectedfilename0"));

    @Name("Кнопка обновления тикета")
    private SelenideElement updateTicketButton = $x("//*[@id=\"content-wrapper\"]/div/div[3]/div[2]/form/button");

    @Name("Кнопка дополнительных изменений")
    private SelenideElement changeDetailsButton = $(By.id("ShowFurtherEditOptions"));


}
