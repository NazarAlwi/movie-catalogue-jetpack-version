package com.learn.moviecataloguejetpackversion.fragment;

import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.MainActivity;
import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MoviesFragmentTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MoviesFragment moviesFragment = new MoviesFragment();

    @Before
    public void setUp() {
//        mainActivityActivityTestRule.getActivity().view;
    }

    @Test
    public void loadMoviesFragment() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.img_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_name)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_vote)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).check(new RecyclerViewItemCountAssertion(10));
    }

}