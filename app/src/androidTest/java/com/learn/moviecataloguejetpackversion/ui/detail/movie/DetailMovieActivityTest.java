package com.learn.moviecataloguejetpackversion.ui.detail.movie;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.utils.EspressoIdlingResource;
import com.learn.moviecataloguejetpackversion.utils.FakeMovieData;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailMovieActivityTest {
    private Movie dummyMovie = FakeMovieData.generateMovieList().get(0);

    @Rule
    public ActivityTestRule<DetailMovieActivity> activityRule = new ActivityTestRule<DetailMovieActivity>(DetailMovieActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailMovieActivity.class);
            result.putExtra(DetailMovieActivity.EXTRA_MOVIES, dummyMovie.getIdMovie());
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovieDetail() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.img_movie_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.img_backdrop_movie_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_name_movie_detail)).check(matches(withText(dummyMovie.getNameMovie())));
        onView(withId(R.id.tv_release_movie_detail)).check(matches(withText(dummyMovie.getReleaseMovie())));
        onView(withId(R.id.tv_vote_movie_detail)).check(matches(withText(dummyMovie.getVoteMovie())));
        onView(withId(R.id.tv_popularity_movie_detail)).check(matches(withText(dummyMovie.getPopularityMovie())));
        onView(withId(R.id.tv_overview_movie_detail)).check(matches(withText(dummyMovie.getOverviewMovie())));
    }
}