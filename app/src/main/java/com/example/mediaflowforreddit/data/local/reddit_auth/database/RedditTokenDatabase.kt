package com.example.mediaflowforreddit.data.local.reddit_auth.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mediaflowforreddit.data.local.reddit_auth.dao.RedditTokenDao
import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity

@Database(entities = [RedditTokenEntity::class], version = 1, exportSchema = true)
abstract class RedditTokenDatabase : RoomDatabase() {
    abstract fun redditTokenDao(): RedditTokenDao
}