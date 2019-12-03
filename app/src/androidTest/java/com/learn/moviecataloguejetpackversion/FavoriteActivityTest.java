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
    public void loadMainActivity() {

    }

    @Test
    public void toDetailMovieTest() {

    }

    @Test
    public void toDetailTvShowTest() {

    }
}