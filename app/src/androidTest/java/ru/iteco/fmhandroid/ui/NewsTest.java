package ru.iteco.fmhandroid.ui;

import static ru.iteco.fmhandroid.ui.data.DataHelper.category;
import static ru.iteco.fmhandroid.ui.data.DataHelper.description;
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
@Story("Новости")

public class NewsTest {

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
    public void createNews() {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, category, planingDate, planingTime, description);
        AllNews.searchByTitle(uniqTitle);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(category, startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        DeleteNews.deleteNews();
    }

    @Test
    public void createNewsWithExceptionFillEmptyFields() {
        try {
            Main.goToNews();
            News.goToEditNews();
            EditNews.goToAddNews();
            AddNews.createNews(uniqTitle, category, planingDate, planingTime, "");
        } catch (Exception e) {

        } finally {
            AddNews.createNews(uniqTitle, category, planingDate, planingTime, description);
            AllNews.searchByTitle(uniqTitle);
            FilterNews.goToWindowOfFilterNews();
            FilterNews.filterNews(category, startPublicationDate, endPublicationDate);
            AllNews.selectNews();
            AllNews.checkingTheNewsDescription(description);
            DeleteNews.deleteNews();
        }
    }
}
