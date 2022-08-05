package com.example.mediaflowforreddit.data.local.reddit_auth.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mediaflowforreddit.data.local.reddit_auth.RedditAuthData
import java.sql.Date
import java.time.LocalDateTime

@Entity
data class RedditTokenEntity(
    @PrimaryKey
    val index: String = RedditAuthData.INDEX,
    val accessToken: String,
    val refreshToken: String,
    val tokenDateTime: String
)
