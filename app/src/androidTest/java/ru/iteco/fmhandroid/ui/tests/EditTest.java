package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.DataHelper.category;
import static ru.iteco.fmhandroid.ui.data.DataHelper.description;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editCategory;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editDescription;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editEndPublicationDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editPlaningDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editPlaningTime;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editStartPublicationDate;
import static ru.iteco.fmhandroid.ui.data.DataHelper.editUniqTitle;
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
import ru.iteco.fmhandroid.ui.AppActivity;
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
@Story("Редактирование новостей")
public class EditTest {

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
    public void editNewsTest() {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, category, planingDate, planingTime, description);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(category, startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        EditNews.editCardNews();
        EditNews.flagActiveNews();
        EditNews.flagNotActiveNews();
        AddNews.createNews(editUniqTitle, editCategory, editPlaningDate, editPlaningTime, editDescription);
        FilterNews.cancelAllFilters();
        AllNews.searchByTitle(editUniqTitle);
        AllNews.doNotExists(uniqTitle);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(editCategory, editStartPublicationDate, editEndPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(editDescription);
        DeleteNews.deleteNews();
    }

    @Test
    public void cancelNewsChangeTest() {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, category, planingDate, planingTime, description);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(category, startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        EditNews.editCardNews();
        AddNews.cancelCreateNews(editUniqTitle, editCategory, editPlaningDate, editPlaningTime, editDescription);
        FilterNews.cancelAllFilters();
        AllNews.searchByTitle(uniqTitle);
        AllNews.doNotExists(editUniqTitle);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.chooseCategory(category);
        FilterNews.clickButtonFilter();
        AllNews.checkingTheNewsDescription(description);
        DeleteNews.deleteNews();
    }

    @Test
    public void editNotActiveNewsTest() {
        Main.goToNews();
        News.goToEditNews();
        EditNews.goToAddNews();
        AddNews.createNews(uniqTitle, category, planingDate, planingTime, description);
        FilterNews.goToWindowOfFilterNews();
        FilterNews.filterNews(category, startPublicationDate, endPublicationDate);
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        EditNews.editCardNews();
        EditNews.flagActiveNews();
        AddNews.save();
        AllNews.searchByTitle(uniqTitle);
        AllNews.newsStatusNotActive();
        AllNews.selectNews();
        AllNews.checkingTheNewsDescription(description);
        DeleteNews.deleteNews();
    }

}
