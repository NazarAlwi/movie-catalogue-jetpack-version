package com.learn.moviecataloguejetpackversion.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;

@Database(entities = {Movie.class, TvShow.class},
        version = 1,
        exportSchema = false)
public abstract class MovieCatalogueDatabase extends RoomDatabase {
    private static MovieCatalogueDatabase INSTANCE;

    public abstract MovieCatalogueDao movieCatalogueDao();

    private static final Object sLock = new Object();

    public static MovieCatalogueDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MovieCatalogueDatabase.class, "MovieCatalogue.db")
                        .build();
            }
            
            return INSTANCE;
        }
    }
}
