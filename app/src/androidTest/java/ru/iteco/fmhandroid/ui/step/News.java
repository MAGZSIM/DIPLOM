package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static io.qameta.allure.kotlin.Allure.step;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

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




    public static void setupDate(String date) {
        ViewInteraction textInputEditText10 = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.news_item_publish_date_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        ViewMatchers.withId(R.id.news_item_create_date_text_input_layout),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()));
        textInputEditText10.perform(ViewActions.replaceText(date));
    }

    public static void goToEditNews() {
        step("Переход к окну Редактирование новостей", stepContext -> {
            ViewInteraction materialButton = Espresso.onView((ViewMatchers.withId(R.id.edit_news_material_button)));
            materialButton.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            materialButton.perform(ViewActions.click());
            return null;
        });

    }

    static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}