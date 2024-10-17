package ru.iteco.fmhandroid.ui.step;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static io.qameta.allure.kotlin.Allure.step;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class Menu {

    public static void goToMenu() {
        step("Переход в меню приложения", stepContext -> {
            ViewInteraction appCompatImageButton = Espresso.onView(allOf(ViewMatchers.withId(R.id.main_menu_image_button), ViewMatchers.withContentDescription("Main menu")));
            appCompatImageButton.check((matches(ViewMatchers.isDisplayed())));
            appCompatImageButton.perform(ViewActions.click());
            return null;
        });
    }

    public static void goToSectionMain() {
        step("Переход в раздел 'Main' меню приложения", stepContext -> {

            ViewInteraction materialTextView = Espresso.onView(allOf(ViewMatchers.withId(android.R.id.title), ViewMatchers.withText("Main")));
            materialTextView.check((matches(ViewMatchers.isDisplayed())));
            materialTextView.perform(ViewActions.click());
            return null;
        });
    }

    public static void goToSectionNews() {
        step("Переход в раздел 'News' меню приложения", stepContext -> {
            ViewInteraction materialTextView = Espresso.onView(allOf(ViewMatchers.withId(android.R.id.title), ViewMatchers.withText("News")));
            materialTextView.check((matches(ViewMatchers.isDisplayed())));
            materialTextView.perform(ViewActions.click());
            return null;
        });
    }

    public static void goToSectionAbout() {
        step("Переход в раздел 'About' меню приложения", stepContext -> {
            ViewInteraction materialTextView = Espresso.onView(allOf(ViewMatchers.withId(android.R.id.title), ViewMatchers.withText("About")));
            materialTextView.check((matches(ViewMatchers.isDisplayed())));
            materialTextView.perform(ViewActions.click());
            return null;
        });
    }

    public static void displayTextInTheSection() {
        step("Отображение текста Version в разделе 'About'", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.about_version_title_text_view), ViewMatchers.withText("Version:")));
            textView.check((matches(withText("Version:"))));
            return null;
        });
    }

    public static void displayTextNumberInTheSection() {
        step("Отображение текста номер версии в разделе 'About'", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.about_version_value_text_view), ViewMatchers.withText("1.0.0")));
            textView.check((matches(withText("1.0.0"))));
            return null;
        });
    }

    public static void displayingALinkToTheSecurityPolicy() {
        step("Отображение ссылки на политику безопасности в разделе 'About'", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.about_privacy_policy_value_text_view), ViewMatchers.withText("https://vhospice.org/#/privacy-policy/")));
            textView.check((matches(withText("https://vhospice.org/#/privacy-policy/"))));
            return null;
        });
    }

    public static void displayingALinkToTheUserAgreement() {
        step("Отображение ссылки на пользовательское соглашение в разделе 'About'", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.about_terms_of_use_value_text_view), ViewMatchers.withText("https://vhospice.org/#/terms-of-use")));
            textView.check((matches(withText("https://vhospice.org/#/terms-of-use"))));
            return null;
        });
    }

    public static void displayOfTheDevelopersCompanyLabel() {
        step("Отображение лейбла компании разработчика приложения в разделе 'About'", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.about_company_info_label_text_view), ViewMatchers.withText("© I-Teco, 2022")));
            textView.check((matches(withText("© I-Teco, 2022"))));
            return null;
        });
    }

    public static void backToMainPage() {
        step("Возвращение на главную страницу приложения", stepContext -> {
            ViewInteraction appCompatImageButton = Espresso.onView(ViewMatchers.withId(R.id.about_back_image_button));
            appCompatImageButton.check((matches(ViewMatchers.isDisplayed())));
            appCompatImageButton.perform(ViewActions.click());
            return null;
        });
    }


    public static void displayOfTheTextElementNews() {
        step("Отображение текстового элемента 'News' новостного блока на главной странице приложения", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withText("News"), ViewMatchers.withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
            textView.check((ViewAssertions.matches(withText("News"))));
            return null;
        });
    }

    public static void aButtonThatOpensOrClosesANewsBlock() {
        step("Закрытие или открытие новостного блока на главной странице приложения", stepContext -> {
            ViewInteraction materialButton = Espresso.onView(ViewMatchers.withId(R.id.expand_material_button));
            materialButton.check((matches(ViewMatchers.isDisplayed())));
            materialButton.perform(ViewActions.click());
            return null;
        });
    }


    public static void displayOfTheLinkElementAllNews() {
        step("Отображение ссылочного элемента 'AllNews' новостного блока на главной странице приложения", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withId(R.id.all_news_text_view), ViewMatchers.withText("ALL NEWS")));
            textView.check((matches(withText("ALL NEWS"))));
            return null;
        });
    }

    public static void displayOfTheCardBlock() {
        step("Отображение макета ограничения блока всех новостных карточек на главной странице приложения", stepContext -> {
            ViewInteraction viewGroup = Espresso.onView(allOf(ViewMatchers.withId(R.id.all_news_cards_block_constraint_layout),
                    ViewMatchers.withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))))));
            viewGroup.check((matches(isDisplayed())));
            return null;
        });
    }


    public static void displayOfTheListNews() {
        step("Отображение списка новостей на главной странице приложения", stepContext -> {
            ViewInteraction recyclerView = Espresso.onView(allOf(ViewMatchers.withId(R.id.news_list_recycler_view),
                    ViewMatchers.withParent(allOf(withId(R.id.all_news_cards_block_constraint_layout),
                            withParent(withId(R.id.container_list_news_include_on_fragment_main))))));
            recyclerView.check((matches(isDisplayed())));
            return null;
        });
    }

    public static void displayOfTheTextElementNewsSectionNews() {
        step("Отображение текстового элемента 'News' новостного блока на странице приложения News", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withText("News"), ViewMatchers.withParent(withParent(withId(R.id.container_list_news_include)))));
            textView.check((ViewAssertions.matches(withText("News"))));
            return null;
        });
    }

    public static void buttonSortingSectionNews() {
        step("Сортировка новостей на странице приложения News", stepContext -> {
            ViewInteraction compoundButton = Espresso.onView(allOf(ViewMatchers.withId(R.id.sort_news_material_button),
                    ViewMatchers.withContentDescription("Sort news list button"),
                    ViewMatchers.withParent(withParent(withId(R.id.container_list_news_include)))));
            compoundButton.check((matches(ViewMatchers.isDisplayed())));
            compoundButton.perform(ViewActions.click());
            return null;
        });
    }

    public static void buttonFilterSectionNews() {
        step("Фильтр новостей на странице приложения News", stepContext -> {
            ViewInteraction compoundButton = Espresso.onView(allOf(ViewMatchers.withId(R.id.filter_news_material_button),
                    ViewMatchers.withParent(withParent(withId(R.id.container_list_news_include)))));
            compoundButton.check((matches(ViewMatchers.isDisplayed())));
            compoundButton.perform(ViewActions.click());
            return null;
        });
    }

    public static void buttonEditSectionNews() {
        step("Редактирование новостей на странице приложения News", stepContext -> {
            ViewInteraction compoundButton = Espresso.onView(allOf(ViewMatchers.withId(R.id.edit_news_material_button),
                    ViewMatchers.withParent(withParent(withId(R.id.container_list_news_include)))));
            compoundButton.check((matches(ViewMatchers.isDisplayed())));
            compoundButton.perform(ViewActions.click());
            return null;
        });
    }

    public static void displayOfTheTextElementControlPanel() {
        step("Отображение текстового элемента 'ControlPanel' после нажатия кнопки 'Edit' на странице приложения News", stepContext -> {
            ViewInteraction textView = Espresso.onView(allOf(ViewMatchers.withText("Control panel"), ViewMatchers.withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))));
            textView.check((ViewAssertions.matches(withText("Control panel"))));
            return null;
        });
    }

    public static void displayOfTheCardBlockSectionNews() {
        step("Отображение макета ограничения блока всех новостных карточек на странице приложения 'News'", stepContext -> {
            ViewInteraction viewGroup = Espresso.onView(allOf(ViewMatchers.withId(R.id.all_news_cards_block_constraint_layout),
                    ViewMatchers.withParent(allOf(withId(R.id.container_list_news_include),
                            withParent(withId(R.id.news_list_swipe_refresh))))));
            viewGroup.check((matches(isDisplayed())));
            return null;
        });
    }


    public static void displayOfTheListNewsSectionNews() {
        step("Отображение списка новостей на странице приложения 'News'", stepContext -> {
            ViewInteraction recyclerView = Espresso.onView(allOf(ViewMatchers.withId(R.id.news_list_recycler_view),
                    ViewMatchers.withParent(allOf(withId(R.id.all_news_cards_block_constraint_layout),
                            withParent(withId(R.id.container_list_news_include))))));
            recyclerView.check((matches(isDisplayed())));
            return null;
        });
    }

}
