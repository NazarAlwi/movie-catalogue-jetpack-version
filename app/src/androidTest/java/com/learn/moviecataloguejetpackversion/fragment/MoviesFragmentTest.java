package com.learn.moviecataloguejetpackversion.fragment;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.testing.SingleFragmentActivity;
import com.learn.moviecataloguejetpackversion.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MoviesFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> mainActivityActivityTestRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MoviesFragment moviesFragment = new MoviesFragment();

    @Before
    public void setUp() {
        mainActivityActivityTestRule.getActivity().setFragment(moviesFragment);
    }

    @Test
    public void loadMoviesFragment() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(swipeUp());
        onView(withId(R.id.rv_movies)).perform(swipeDown());
        onView(withId(R.id.rv_movies)).check(new RecyclerViewItemCountAssertion(10));
    }

    @Test
    public void toDetailMovieTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.tv_name_movie_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_name_movie_detail)).check(matches(withText("Joker")));
    }
}