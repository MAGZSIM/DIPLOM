package ru.iteco.fmhandroid.ui;


import static ru.iteco.fmhandroid.ui.data.DataHelper.category;
import static ru.iteco.fmhandroid.ui.data.DataHelper.description;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editEndPublicationDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editPlaningDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editPlaningTime;
import static ru.iteco.fmhandroid.ui.data.DataHelper.endPublicationDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.planingDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.planingTime;
import static ru.iteco.fmhandroid.ui.data.DataHelper.startPublicationDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.uniqTitle;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.idle.IdleService;
import ru.iteco.fmhandroid.ui.step.AddNews;
import ru.iteco.fmhandroid.ui.step.AllNews;
import ru.iteco.fmhandroid.ui.step.Auth;
import ru.iteco.fmhandroid.ui.step.DeleteNews;
import ru.iteco.fmhandroid.ui.step.EditNews;
import ru.iteco.fmhandroid.ui.step.FilterNews;
import ru.iteco.fmhandroid.ui.step.Main;
import ru.iteco.fmhandroid.ui.step.News;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Story("Сортировка новостей")

public class SortTest {

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
    public void newsOutsideTheVisibleAreaAfterSorting() {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews("111", "День рождения", planingDate, planingTime, "111");
        EditNews.goToAddNews();
        AddNews.createNews("222", "Благодарность", planingDate, planingTime, "222");
        EditNews.goToAddNews();
        AddNews.createNews("333", "Нужна помощь", planingDate, planingTime, "333");
        EditNews.goToAddNews();
        AddNews.createNews("444", "Массаж", planingDate, planingTime, "444");
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, category, editPlaningDate, planingTime, description);
        News.sort();
        AllNews.doNotExists(uniqTitle);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(category, startPublicationDate, editEndPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("День рождения", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("111");
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("Благодарность", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("222");
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("Нужна помощь", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("333");
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("Массаж", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("444");
        DeleteNews.deleteNews();
    }

    @Test
    public void sortCheckByTitle() throws InterruptedException {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews("111", "День рождения", planingDate, editPlaningTime, "111");
        EditNews.goToAddNews();
        AddNews.createNews("222", "Благодарность", planingDate, editPlaningTime, "222");
        EditNews.goToAddNews();
        AddNews.createNews("333", "Нужна помощь", planingDate, editPlaningTime, "333");
        EditNews.goToAddNews();
        AddNews.createNews("444", "Массаж", planingDate, editPlaningTime, "444");
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, category, editPlaningDate, planingTime, description);
        News.sort();
        AllNews.doNotExists(uniqTitle);
        News.sort();
        News.searchAfterSort(uniqTitle);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(category, startPublicationDate, editEndPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("День рождения", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("111");
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("Благодарность", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("222");
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("Нужна помощь", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("333");
        DeleteNews.deleteNews();
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews("Массаж", startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription("444");
        DeleteNews.deleteNews();
    }

}
