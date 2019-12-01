package com.learn.moviecataloguejetpackversion.ui.favoritetvshow;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.testing.SingleFragmentActivity;
import com.learn.moviecataloguejetpackversion.utils.EspressoIdlingResource;
import com.learn.moviecataloguejetpackversion.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
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

public class TvShowsFavoriteFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> mainActivityActivityTestRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvShowsFavoriteFragment tvShowsFavoriteFragment = new TvShowsFavoriteFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        mainActivityActivityTestRule.getActivity().setFragment(tvShowsFavoriteFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTvShowFavoriteFragment() {
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_shows)).perform(swipeUp());
        onView(withId(R.id.rv_tv_shows)).perform(swipeDown());
        onView(withId(R.id.rv_tv_shows)).check(new RecyclerViewItemCountAssertion(10));
    }

    @Test
    public void toDetailTvShowTest() {
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_name_tv_show_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_name_tv_show_detail)).check(matches(withText("Arrow")));
    }
}