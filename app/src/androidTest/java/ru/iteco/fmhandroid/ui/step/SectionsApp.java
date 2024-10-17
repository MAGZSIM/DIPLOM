package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static io.qameta.allure.kotlin.Allure.step;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import ru.iteco.fmhandroid.R;

import org.hamcrest.core.IsInstanceOf;

public class SectionsApp {


    public static void displayOfTheTextElementLoveIsAll() {
        step("Отображение текстового элемента 'Love is all' на странице приложения Our Mission", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_title_text_view),
                    ViewMatchers.withText("Love is all"), ViewMatchers.withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))));
            textView.check((ViewAssertions.matches(withText("Love is all"))));
            return null;
        });
    }

    public static void displayOfTheListQuotesSectionOurMission() {
        step("Отображение списка цитат на странице приложения Our Mission", stepContext -> {
            ViewInteraction recyclerView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_list_recycler_view),
                    ViewMatchers.withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))));
            recyclerView.check((ViewAssertions.matches(isDisplayed())));
            return null;
        });
    }

    public static void quoteCardSelection(int position) {
        step("Выбор первой карточки с цитатами", stepContext -> {
            ViewInteraction recyclerView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_list_recycler_view), childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                    0)));
            recyclerView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            recyclerView.perform(actionOnItemAtPosition(position, click()));
            return null;
        });
    }


    public static void quoteFirstCardSelection() {
        step("Выбор первой карточки с цитатами", stepContext -> {
            ViewInteraction recyclerView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_list_recycler_view), childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                    0)));
            recyclerView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            recyclerView.perform(actionOnItemAtPosition(0, click()));
            return null;
        });
    }

    public static void displayTitleTextFirstCard() {
        step("Отображение титульного текста первой цитаты на странице Our Mission", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_title_text_view),
                    ViewMatchers.withText("«Хоспис для меня - это то, каким должен быть мир.\""), ViewMatchers.withParent(withParent(withId(R.id.our_mission_item_material_card_view)))));
            textView.check((ViewAssertions.matches(withText("«Хоспис для меня - это то, каким должен быть мир.\""))));
            return null;
        });
    }

    public static void displayDescriptionTextFirstCard() {
        step("Отображение текста описания первой цитаты на странице Our Mission", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_description_text_view),
                    ViewMatchers.withText("\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер"),
                    ViewMatchers.withParent(withParent(withId(R.id.our_mission_item_material_card_view)))));
            textView.check((ViewAssertions.matches(withText("\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер"))));
            return null;
        });
    }

    public static void displayTitleTextCard(String title) {
        step("Отображение титульного текста первой цитаты на странице Our Mission", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_title_text_view),
                    ViewMatchers.withText(title), ViewMatchers.withParent(withParent(withId(R.id.our_mission_item_material_card_view)))));
            textView.check((ViewAssertions.matches(withText(title))));
            return null;
        });
    }

    public static void displayDescriptionTextCard(String description) {
        step("Отображение текста описания первой цитаты на странице Our Mission", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.our_mission_item_description_text_view),
                    ViewMatchers.withText(description),
                    ViewMatchers.withParent(withParent(withId(R.id.our_mission_item_material_card_view)))));
            textView.check((ViewAssertions.matches(withText(description))));
            return null;
        });
    }

}
