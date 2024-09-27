package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;

public class AllNews {

    public static void goToEditNews() {
        ViewInteraction materialButton = Espresso.onView((ViewMatchers.withId(R.id.edit_news_material_button)));
        materialButton.check(matches(ViewMatchers.isDisplayed()));
        materialButton.perform(ViewActions.click());
    }

    public static void searchByTitle(String uniqTitle) {
        step("Поиск новости по заголовку " + uniqTitle, stepContext -> {
            ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_title_text_view), ViewMatchers.withText(uniqTitle)));
            textView.check(matches(ViewMatchers.withText(uniqTitle)));
            return null;
        });

    }

    public static void sort() {
        step("Сортировка новостей", stepContext -> {
            ViewInteraction materialButton4 = Espresso.onView(ViewMatchers.withId(R.id.sort_news_material_button));
            materialButton4.check(matches(ViewMatchers.isDisplayed()));
            materialButton4.perform(ViewActions.click());
            return null;
        });

    }

    public static void searchByDate(String dateText) {
        /*step("Поиск новости по дате " + dateText, stepContext -> {
            ViewInteraction textView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.news_item_publication_date_text_view), ViewMatchers.withText(dateText)));
            textView.check(matches(ViewMatchers.withText(dateText)));
            return null;
        });*/
        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_publication_date_text_view), withText(dateText),
                        isDisplayed()));
        textView.check(matches(allOf(withText(dateText), isDisplayed())));
    }

}
