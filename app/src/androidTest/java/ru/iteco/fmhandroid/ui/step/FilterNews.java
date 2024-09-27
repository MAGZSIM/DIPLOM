package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;

public class FilterNews {

    public static void chooseCategory(String category) {
        step("Установка категории " + category, stepContext -> {
            ViewInteraction checkableImageButton = onView(
                    allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));
            checkableImageButton.check(matches(isDisplayed()));
            checkableImageButton.perform(click());

            onView(withText(category))
                    .inRoot(RootMatchers.isPlatformPopup())
                    .perform(click());
            return null;
        });

    }

    public static void chooseStartPublicationDate(String startPublicationDate) {
        step("Установка даты старта публикации " + startPublicationDate, stepContext -> {
            ViewInteraction textInputEditText = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
            textInputEditText.check(matches(isDisplayed()));
            textInputEditText.perform(replaceText(startPublicationDate), closeSoftKeyboard());
            return null;
        });
    }

    public static void chooseEndPublicationDate(String endPublicationDate) {
        step("Установка даты конца публикации " + endPublicationDate, stepContext -> {
            ViewInteraction textInputEditText = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
            textInputEditText.check(matches(isDisplayed()));
            textInputEditText.perform(replaceText(endPublicationDate), closeSoftKeyboard());
            return null;
        });
    }

    public static void clickCheckboxActive() {
        step("Клик на чекбоксе active", stepContext -> {
            ViewInteraction materialCheckBox = onView(
                    allOf(withId(R.id.filter_news_active_material_check_box)));
            materialCheckBox.perform(click());
            return null;
        });

    }

    public static void clickCheckboxInactive() {
        step("Клик на чекбоксе inactive", stepContext -> {
            ViewInteraction materialCheckBox3 = onView(
                    allOf(withId(R.id.filter_news_inactive_material_check_box)));
            materialCheckBox3.perform(click());
            return null;
        });

    }

    public static void clickButtonFilter() {
        step("Клик применить фильтр", stepContext -> {
            ViewInteraction materialButton5 = onView(
                    allOf(withId(R.id.filter_button), withText("Filter")));
            materialButton5.perform(click());
            return null;
        });

    }



}
