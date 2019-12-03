package com.learn.moviecataloguejetpackversion;


import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class FavoriteActivityTest {
    @Rule
    public ActivityTestRule<FavoriteActivity> dummyMainActivityActivityTestRule = new ActivityTestRule<>(FavoriteActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadFavoriteActivity() {
        onView(withText("My Favorite")).check(matches(isDisplayed()));
        onView(withText(R.string.movie)).check(matches(isDisplayed()));
        onView(withText(R.string.tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.tabs)).check(matches(isDisplayed()));
        onView(withId(R.id.viewpager)).check(matches(isDisplayed()));
    }

    @Test
    public void toDetailMovieTest() {

    }

    @Test
    public void toDetailTvShowTest() {

    }
}