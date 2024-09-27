package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;
import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.idle.IdleService;
import ru.iteco.fmhandroid.ui.step.AddNews;
import ru.iteco.fmhandroid.ui.step.AllNews;
import ru.iteco.fmhandroid.ui.step.Auth;
import ru.iteco.fmhandroid.ui.step.EditNews;
import ru.iteco.fmhandroid.ui.step.FilterNews;
import ru.iteco.fmhandroid.ui.step.Main;
import ru.iteco.fmhandroid.ui.step.News;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Story("Новости")
public class NewsTest {

    String category = "Зарплата";
    String startPublicationDate = "25.09.2024";
    String endPublicationDate = "30.10.2024";
    Date currentDate = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    String currentDateText = dateFormat.format(currentDate);
    DateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
    String currentTimeText = timeFormat.format(currentDate);

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void before() {
        IdlingRegistry.getInstance().register(IdleService.idleCounter);
        try {
             Auth.login();
        } catch (Exception e) {
            //Ничего не делаем
        }
    }

    @After
    public void after() {
        IdlingRegistry.getInstance().unregister(IdleService.idleCounter);
        try {
            //Auth.logout();
        } catch (Exception e) {
            //Ничего не делаем
        }
    }

    @Test
    public void createNews_sort_checkByTitle() {
        String uniqTitle = UUID.randomUUID().toString();
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, "Зарплата", currentDateText, currentTimeText, "uniqDescription");
        AllNews.sort();
        AllNews.searchByTitle(uniqTitle);
        //Здесь должен быть метод удаляющий созданную новость
    }



    //@Test
    public void filterNews() {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToFilterNews();
        FilterNews.chooseCategory(category);
        FilterNews.chooseStartPublicationDate(startPublicationDate);
        FilterNews.chooseEndPublicationDate(endPublicationDate);
        // снимаем галку с чекбокса объявление активно:
        FilterNews.clickCheckboxActive();
        // ставим галку в чекбокса объявление активно:
        FilterNews.clickCheckboxActive();
        // снимаем галку с чекбокса объявление не активно:
        FilterNews.clickCheckboxInactive();
        // ставим галку в чекбокса объявление не активно:
        FilterNews.clickCheckboxInactive();
        // нажимаем кнопку фильтр
        FilterNews.clickButtonFilter();

        step("Проверяем что результат это список вида recycler_view ", stepContext -> {
            ViewInteraction recyclerView = onView(
                    allOf(withId(R.id.news_list_recycler_view),
                            withParent(withParent(withId(R.id.news_control_panel_swipe_to_refresh))),
                            isDisplayed()));
            recyclerView.check(matches(isDisplayed()));
            return null;
        });

        //  убираем активные фильтры
        EditNews.goToFilterNews();
        FilterNews.clickButtonFilter();
    }

    //@Test
    public void sortNews() {
        String uniqTitle = UUID.randomUUID().toString();
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, "Зарплата", currentDateText, currentTimeText, "uniqDescription");
        AllNews.sort();
        AllNews.searchByDate("27.09.2024");
        ///// сортируем
       /* ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        materialButton2.check(matches(isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_publication_date_text_view), withText(currentDateText),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView.check(matches(allOf(withText(currentDateText), isDisplayed())));*/
        //Здесь должен быть метод удаляющий созданную новость
    }

}
