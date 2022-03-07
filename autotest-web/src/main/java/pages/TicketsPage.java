package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.web.annotations.Name;
import ru.lanit.at.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "TicketsPage")
public class TicketsPage extends WebPage {

    @Name("Поле поиска тикета")
    private SelenideElement inputSearch = $(By.id("search_query"));

    @Name("Кнопка поиска тикета")
    private SelenideElement goSearchButton = $x("//*[@id=\"searchform\"]/div/div/button");

    @Name("Cохранение запроса")
    private SelenideElement saveQuery= $x("//*[@id=\"headingTwo\"]/h5/button");

    @Name("Название запроса")
    private SelenideElement inputQueryName = $(By.id("id_title"));

    @Name("Кнопка сохранения запроса")
    private SelenideElement saveQueryButton = $x("//*[@id=\"collapseTwo\"]/div/form/div/input");

    @Name("Имя выбранного запроса")
    private SelenideElement queryName = $x("//*[@id=\"collapseOne\"]/form/ul/li[9]/strong");

}
