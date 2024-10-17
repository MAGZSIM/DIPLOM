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
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;
import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.R;

public class EditNews {

    public static void goToAddNews() {
        step("Переход к окну редактировани новостей", stepContext -> {
            ViewInteraction materialButton2 = Espresso.onView((ViewMatchers.withId(R.id.add_news_image_view)));
            materialButton2.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            materialButton2.perform(ViewActions.click());
            return null;
        });

    }

    public static void editCardNews() {
        step("Редактирование карточки новостей", stepContext -> {
            ViewInteraction appCompatImageView = onView(
                    allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(R.id.news_item_material_card_view),
                                            0),
                                    15),
                            isDisplayed()));
            appCompatImageView.perform(click());
            return null;

        });
    }

    public static void flagActiveNews() {
        step("Переключение флага активная новость", stepContext -> {
            ViewInteraction switchMaterial = onView(
                    allOf(withId(R.id.switcher), withText("Active"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("com.google.android.material.card.MaterialCardView")),
                                            0),
                                    5)));
            switchMaterial.perform(scrollTo(), click());
            return null;
        });
    }

    public static void flagNotActiveNews() {
        step("Переключение флага неактивная новость", stepContext -> {
            ViewInteraction switchMaterial2 = onView(
                    allOf(withId(R.id.switcher), withText("Not active"),
                            childAtPosition(
                                    childAtPosition(
                                            withClassName(is("com.google.android.material.card.MaterialCardView")),
                                            0),
                                    5)));
            switchMaterial2.perform(scrollTo(), click());
            return null;
        });
    }
}