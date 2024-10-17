package ru.iteco.fmhandroid.ui.step;

import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;


public class News {

    public static void searchAfterSort(String uniqTitle) {
        ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_title_text_view), ViewMatchers.withText(uniqTitle)));
        textView.check(ViewAssertions.matches(ViewMatchers.withText(uniqTitle)));
    }

    public static void sort() {
        ViewInteraction materialButton4 = Espresso.onView(ViewMatchers.withId(R.id.sort_news_material_button));
        materialButton4.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        materialButton4.perform(ViewActions.click());
    }

    public static void goToEditNews() {
        step("Переход к окну Редактирование новостей", stepContext -> {
            ViewInteraction materialButton = Espresso.onView((ViewMatchers.withId(R.id.edit_news_material_button)));
            materialButton.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            materialButton.perform(ViewActions.click());
            return null;
        });
    }
}