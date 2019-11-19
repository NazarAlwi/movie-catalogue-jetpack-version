package com.learn.moviecataloguejetpackversion.activity;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.model.MainViewModel;
import com.learn.moviecataloguejetpackversion.model.Movie;
import com.learn.moviecataloguejetpackversion.model.TvShow;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class DetailTvShowActivityTest {
    private TvShow dummyTvShow = MainViewModel.getListTvShow().get(0);

    @Rule
    public ActivityTestRule<DetailTvShowActivity> activityRule = new ActivityTestRule<DetailTvShowActivity>(DetailTvShowActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTvShowActivity.class);
            result.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, dummyTvShow.getNameTvShow());
            return result;
        }
    };

    @Test
    public void loadMovieDetail() {
        onView(withId(R.id.img_tv_show_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.img_backdrop_tv_show_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_name_tv_show_detail)).check(matches(withText(dummyTvShow.getNameTvShow())));
        onView(withId(R.id.tv_release_tv_show_detail)).check(matches(withText(dummyTvShow.getReleaseTvShow())));
        onView(withId(R.id.tv_vote_tv_show_detail)).check(matches(withText(dummyTvShow.getVoteTvShow())));
        onView(withId(R.id.tv_popularity_tv_show_detail)).check(matches(withText(dummyTvShow.getPopularityTvShow())));
        onView(withId(R.id.tv_overview_tv_show_detail)).check(matches(withText(dummyTvShow.getOverviewTvShow())));
    }
}