package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class DeleteNews {

    public static void deleteNews() {
        step("Удаляем новость", stepContext -> {
            ViewInteraction appCompatImageView = onView(
                    allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(R.id.news_item_material_card_view),
                                            0),
                                    14),
                            isDisplayed()));
            appCompatImageView.perform(click());

            ViewInteraction materialButton = onView(
                    allOf(withId(android.R.id.button1), withText("OK"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    3)));
            materialButton.perform(scrollTo(), click());
            return null;
        });
    }

    public static void cancelDeleteNews() {
        step("Отмена удаления новости", stepContext -> {
            ViewInteraction appCompatImageView = onView(
                    allOf(withId(R.id.delete_news_item_image_view), withContentDescription("News delete button"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(R.id.news_item_material_card_view),
                                            0),
                                    14),
                            isDisplayed()));
            appCompatImageView.perform(click());

            ViewInteraction materialButton = onView(
                    allOf(withId(android.R.id.button2), withText("Cancel"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("android.widget.ScrollView")),
                                            0),
                                    2)));
            materialButton.perform(scrollTo(), click());
            return null;
        });
    }
}
