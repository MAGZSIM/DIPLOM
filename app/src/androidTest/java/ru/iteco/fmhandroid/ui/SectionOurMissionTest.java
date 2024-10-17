package ru.iteco.fmhandroid.ui;

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
import ru.iteco.fmhandroid.ui.step.Auth;
import ru.iteco.fmhandroid.ui.step.Main;
import ru.iteco.fmhandroid.ui.step.SectionsApp;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Story("Наша Миссия")
public class SectionOurMissionTest {

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
    public void sectionOurMission() {
        Main.goToSectionOurMission();
        SectionsApp.displayOfTheTextElementLoveIsAll();
        SectionsApp.displayOfTheListQuotesSectionOurMission();
    }


    @Test
    public void sectionOurMissionFirstCardSelection() {
        Main.goToSectionOurMission();
        SectionsApp.quoteFirstCardSelection();
        SectionsApp.displayTitleTextFirstCard();
        SectionsApp.displayDescriptionTextFirstCard();
        SectionsApp.quoteFirstCardSelection();
    }

    @Test
    public void sectionOurMissionSecondCardSelection() {
        Main.goToSectionOurMission();
        SectionsApp.quoteCardSelection(1);
        SectionsApp.displayTitleTextCard("«Хоспис для меня - это то, каким должен быть мир.\"");
        SectionsApp.displayDescriptionTextCard("Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.");
        SectionsApp.quoteCardSelection(1);
    }

    @Test
    public void sectionOurMissionEighthCardSelection() {
        Main.goToSectionOurMission();
        SectionsApp.quoteCardSelection(7);
        SectionsApp.displayTitleTextCard("Важен каждый!");
        SectionsApp.displayDescriptionTextCard("\"Каждый, кто оказывается в стенах хосписа, имеет огромное значение в жизни хосписа и его подопечных\"");
        SectionsApp.quoteCardSelection(7);
    }
}
