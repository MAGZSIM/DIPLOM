package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.step.Auth.login;
import static ru.iteco.fmhandroid.ui.step.Auth.logout;

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
import ru.iteco.fmhandroid.ui.step.Main;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Story("Аутентификация")
public class AuthTest {

    String loginValue = "login2";
    String pwdValue = "password2";

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(IdleService.idleCounter);
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(IdleService.idleCounter);
    }

    @Test
    public void authTestSuccess() {
        login();
        Main.checkTrademarkDisplayed(isDisplayed());
        logout();
    }

    @Test
    public void authTestWrongLogin() {
        login("123", pwdValue);
        Main.checkTrademarkDisplayed(not(isDisplayed()));
    }

    @Test
    public void authTestWrongPassword() {
        login(loginValue, "123");
        Main.checkTrademarkDisplayed(not(isDisplayed()));
    }

}
