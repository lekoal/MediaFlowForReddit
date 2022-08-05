package com.example.mediaflowforreddit.data.local.reddit_auth.dao

import androidx.room.*
import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity

@Dao
interface RedditTokenDao {
    @Query("SELECT * FROM RedditTokenEntity")
    fun getAll(): List<RedditTokenEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: RedditTokenEntity)

    @Update
    fun update(entity: RedditTokenEntity)
}