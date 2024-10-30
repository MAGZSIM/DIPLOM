package ru.iteco.fmhandroid.ui.tests;

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
import ru.iteco.fmhandroid.ui.step.Auth;
import ru.iteco.fmhandroid.ui.step.FilterNews;
import ru.iteco.fmhandroid.ui.step.Main;
import ru.iteco.fmhandroid.ui.step.Menu;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Story("Меню")
public class MenuTest {

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
    public void sectionMenuAbout() {
        Menu.goToMenu();
        Menu.goToSectionAbout();
        Menu.displayTextInTheSection();
        Menu.displayTextNumberInTheSection();
        Menu.displayingALinkToTheSecurityPolicy();
        Menu.displayingALinkToTheUserAgreement();
        Menu.displayOfTheDevelopersCompanyLabel();
        Menu.backToMainPage();
    }

    @Test
    public void sectionMenuMain() {
        Menu.displayOfTheTextElementNews();
        Menu.aButtonThatOpensOrClosesANewsBlock();
        Menu.aButtonThatOpensOrClosesANewsBlock();
        Menu.displayOfTheLinkElementAllNews();
        Main.goToNews();
        Menu.goToMenu();
        Menu.goToSectionMain();
        Menu.displayOfTheCardBlock();
        Menu.displayOfTheListNews();

    }

    @Test
    public void sectionMenuNews() {
        Menu.goToMenu();
        Menu.goToSectionNews();
        Menu.displayOfTheTextElementNewsSectionNews();
        Menu.buttonSortingSectionNews();
        Menu.buttonFilterSectionNews();
        FilterNews.clickButtonFilter();
        Menu.buttonEditSectionNews();
        Menu.displayOfTheTextElementControlPanel();
        Menu.goToMenu();
        Menu.goToSectionNews();
        Menu.displayOfTheCardBlockSectionNews();
        Menu.displayOfTheListNewsSectionNews();
    }

}
