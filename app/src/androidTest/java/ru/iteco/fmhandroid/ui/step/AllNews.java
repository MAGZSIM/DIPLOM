package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;

public class AllNews {

    public static void searchByTitle(String uniqTitle) {
        step("Поиск новости по заголовку " + uniqTitle, stepContext -> {
            ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_title_text_view), ViewMatchers.withText(uniqTitle)));
            textView.check(matches(ViewMatchers.withText(uniqTitle)));
            return null;
        });

    }


    public static void doNotExists(String uniqTitle) {
        step("Проверка, что заголовок не существует" + uniqTitle, stepContext -> {
            ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_title_text_view), ViewMatchers.withText(uniqTitle)));
            textView.check(doesNotExist());
            return null;
        });
    }

    public static void newsStatusNotActive() {
        step("Проверка, что статус новости не активен", stepContext -> {
            ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_published_text_view), ViewMatchers.withText("NOT ACTIVE")));
            textView.check(matches(ViewMatchers.withText("NOT ACTIVE")));
            return null;
        });
    }

    public static void newsStatusActive() {
        step("Проверка, что статус новости активен", stepContext -> {
            ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_published_text_view), ViewMatchers.withText("ACTIVE")));
            textView.check(matches(ViewMatchers.withText("ACTIVE")));
            return null;
        });
    }

    public static void selectNews() {
        step("Выбираем новость", stepContext -> {
            ViewInteraction recyclerView = onView(
                    allOf(withId(R.id.news_list_recycler_view),
                            childAtPosition(
                                    withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                    0)));
            recyclerView.perform(actionOnItemAtPosition(0, click()));
            return null;
        });
    }

    public static void checkingTheNewsDescription(String description) {
        step("Сверяем описание новости", stepContext -> {
            ViewInteraction materialTextView3 = onView(
                    allOf(withId(R.id.news_item_description_text_view), withText(description),
                            childAtPosition(
                                    childAtPosition(
                                            withId(R.id.news_item_material_card_view),
                                            0),
                                    17),
                            isDisplayed()));
            materialTextView3.perform(click());
            return null;
        });
    }

}
