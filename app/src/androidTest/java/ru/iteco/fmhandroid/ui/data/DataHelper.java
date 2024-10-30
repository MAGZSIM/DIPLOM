package ru.iteco.fmhandroid.ui.data;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class DataHelper {

    public static String loginValue = "login2";
    public static String pwdValue = "password2";

    public static String wrongLogin = "123";
    public static String wrongPasssword = "123";

    public static String secondTitleTextCard = "«Хоспис для меня - это то, каким должен быть мир.\"";
    public static String secondDescriptionTextCard = "Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.";
    public static String eighthTitleTextCard = "Важен каждый!";
    public static String eighthDescriptionTextCard = "\"Каждый, кто оказывается в стенах хосписа, имеет огромное значение в жизни хосписа и его подопечных\"";

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateTime(int hours) {
        return LocalTime.now().plusHours(hours).format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    public static String planingDate = generateDate(7);
    public static String planingTime = generateTime(7);
    public static String editPlaningDate = generateDate(9);
    public static String editPlaningTime = generateTime(9);

//    public static Date currentDate = new Date();
//    public static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
//    public static String currentDateText = dateFormat.format(currentDate);
//    public static DateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
//    public static String currentTimeText = timeFormat.format(currentDate);

    public static String category = "Зарплата";
    public static String startPublicationDate = planingDate;
    public static String endPublicationDate = planingDate;
    public static String uniqTitle = UUID.randomUUID().toString();
    public static String description = UUID.randomUUID().toString();

    public static String editCategory = "Профсоюз";
    public static String editUniqTitle = UUID.randomUUID().toString();
    public static String editDescription = "uniqDescription2";
    public static String editStartPublicationDate = editPlaningDate;
    public static String editEndPublicationDate = editPlaningDate;

    public static Matcher<View> childAtPosition(
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
