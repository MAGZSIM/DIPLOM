package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;

import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;

public class AddNews {

    public static void createNews(String title, String category, String date, String time, String description) {
        step("Создание новости", stepContext -> {
            setupCategory(category);
            setupTitle(title);
            setupDate(date);
            setupTime(time);
            setupDescription(description);
            save();
            return null;
        });

    }

    public static void cancelCreateNews(String title, String category, String date, String time, String description) {
        step("Отмена создание новости", stepContext -> {
            setupCategory(category);
            setupTitle(title);
            setupDate(date);
            setupTime(time);
            setupDescription(description);
            cancel();
            return null;
        });

    }

    public static void cancel() {
        step("Отмена новости", stepContext -> {
            ViewInteraction materialButton12 = onView(
                    allOf(withId(R.id.cancel_button), withText("Cancel"), withContentDescription("Cancel"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("com.google.android.material.card.MaterialCardView")),
                                            0),
                                    7)));
            materialButton12.perform(scrollTo(), click());

            ViewInteraction materialButton13 = onView(
                    allOf(withId(android.R.id.button1), withText("OK"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(com.google.android.material.R.id.buttonPanel),
                                            0),
                                    3)));
            materialButton13.perform(scrollTo(), click());
            return null;
        });

    }

    public static void save() {
        step("Сохранение новости", stepContext -> {
            ViewInteraction materialButton3 = Espresso.onView(ViewMatchers.withId(R.id.save_button));
            materialButton3.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            materialButton3.perform(scrollTo(), click());
            return null;
        });

    }

    public static void setupDescription(String description) {
        step("Добавление описания " + description, stepContext -> {
            ViewInteraction textInputEditText4 = Espresso.onView(ViewMatchers.withId(R.id.news_item_description_text_input_edit_text));
            textInputEditText4.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            textInputEditText4.perform(ViewActions.replaceText(description), ViewActions.closeSoftKeyboard());
            return null;
        });

    }

    public static void setupTime(String time) {
        step("Добавление времени публикации " + time, stepContext -> {
            ViewInteraction textInputEditText3 = Espresso.onView(ViewMatchers.withId(R.id.news_item_publish_time_text_input_edit_text));
            textInputEditText3.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            textInputEditText3.perform(ViewActions.replaceText(time), ViewActions.closeSoftKeyboard());
            return null;
        });

    }

    public static void setupDate(String date) {
        step("Добавление даты публикации " + date, stepContext -> {
            ViewInteraction textInputEditText10 = Espresso.onView(
                    Matchers.allOf(ViewMatchers.withId(R.id.news_item_publish_date_text_input_edit_text),
                            childAtPosition(
                                    childAtPosition(
                                            ViewMatchers.withId(R.id.news_item_create_date_text_input_layout),
                                            0),
                                    1),
                            ViewMatchers.isDisplayed()));
            textInputEditText10.perform(ViewActions.replaceText(date));
            return null;
        });

    }

    public static void setupTitle(String title) {
        step("Добавление заголовка публикации " + title, stepContext -> {
            ViewInteraction textInputEditText = Espresso.onView(ViewMatchers.withId(R.id.news_item_title_text_input_edit_text));
            textInputEditText.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            textInputEditText.perform(ViewActions.replaceText(title), ViewActions.closeSoftKeyboard());
            return null;
        });

    }

    public static void setupCategory(String category) {
        step("Добавление категории " + category, stepContext -> {
            ViewInteraction checkableImageButton = Espresso.onView(
                    Matchers.allOf(ViewMatchers.withId(R.id.text_input_end_icon), ViewMatchers.withContentDescription("Show dropdown menu"),
                            childAtPosition(
                                    childAtPosition(
                                            ViewMatchers.withClassName(Matchers.is("android.widget.LinearLayout")),
                                            1),
                                    0),
                            ViewMatchers.isDisplayed()));
            checkableImageButton.perform(click());

            Espresso.onView(ViewMatchers.withText(category))
                    .inRoot(RootMatchers.isPlatformPopup())
                    .perform(click());
            return null;
        });
    }
}