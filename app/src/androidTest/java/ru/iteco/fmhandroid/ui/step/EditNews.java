package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import ru.iteco.fmhandroid.R;

public class EditNews {

    public static void goToAddNews() {
        step("Переход к окну Редактирование новостей", stepContext -> {
            ViewInteraction materialButton2 = Espresso.onView((ViewMatchers.withId(R.id.add_news_image_view)));
            materialButton2.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            materialButton2.perform(ViewActions.click());
            return null;
        });

    }

    public static void goToFilterNews() {
        step("Переход к окну Фильтрация новостей", stepContext -> {
            ViewInteraction materialButton2 = onView(
                    allOf(withId(R.id.filter_news_material_button)));
            materialButton2.check(matches(isDisplayed()));
            materialButton2.perform(click());
            return null;
        });

    }

}
