package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static io.qameta.allure.kotlin.Allure.step;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class Main {

    public static void goToNews() {
        step("Переход к окну Новости", stepContext -> {
            ViewInteraction materialTextView = Espresso.onView((ViewMatchers.withId(R.id.all_news_text_view)));
            materialTextView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            materialTextView.perform(ViewActions.click());
            return null;
        });

    }

    public static void goToSectionOurMission() {
        step("Раздел цитаты", stepContext -> {
            ViewInteraction appCompatImageButton = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_image_button),
                    ViewMatchers.withContentDescription("Our Mission")));
            appCompatImageButton.check(ViewAssertions.matches(isDisplayed()));
            appCompatImageButton.perform(ViewActions.click());
            return null;
        });
    }

    public static void checkTrademarkDisplayed(Matcher<View> Displayed) {
        ViewInteraction imageView = onView(withId(R.id.trademark_image_view));
        imageView.check(matches(Displayed));
    }

}
