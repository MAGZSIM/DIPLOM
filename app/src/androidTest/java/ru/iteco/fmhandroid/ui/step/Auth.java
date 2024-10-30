package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;
import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.data.DataHelper.loginValue;
import static ru.iteco.fmhandroid.ui.data.DataHelper.pwdValue;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class Auth {


    @Step
    public static void login(String login, String pwd) {
        step("Аутентификация пользователя", stepContext -> {
        enterLogin(login);
        enterPassword(pwd);
        clickSingIn();
        return null;
    });
    }

    @Step
    public static void login() {
        step("Аутентификация пользователя с зарегистрированными данными", stepContext -> {
        enterLogin(loginValue);
        enterPassword(pwdValue);
        clickSingIn();
            return null;
        });
    }

    /**
     * Выход после успешной аутентификации.
     * Необходим для независимости тестов и возвращению к экрану логина
     */
    @Step
    public static void logout() {
        step("Выход из приложения", stepContext -> {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());
        ViewInteraction materialTextView = onView(
                allOf(withId(android.R.id.title), withText("Log out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());
        //Main.checkTrademarkDisplayed(not(isDisplayed()));
        return null;
    });
    }

    public static void clickSingIn() {
        step("Вход в приложение", stepContext -> {
            ViewInteraction singInButton = onView(withId(R.id.enter_button));
            singInButton.perform(ViewActions.click());
            return null;
        });
    }

    public static void enterPassword(String pwd) {
        step("ввод пароля " + pwd, stepContext -> {
            typeTextInInput(R.id.password_text_input_layout, pwd);
            return null;
        });
    }

    public static void enterLogin(String login) {
        step("ввод логина " + login, stepContext -> {
            typeTextInInput(R.id.login_text_input_layout, login);
            return null;
        });
    }


    public static void typeTextInInput(int id, String text) {
        onView(
                allOf(
                        isDescendantOfA(withId(id)),
                        withClassName(endsWith("EditText"))
                )
        ).perform(typeText(text));
    }

}
