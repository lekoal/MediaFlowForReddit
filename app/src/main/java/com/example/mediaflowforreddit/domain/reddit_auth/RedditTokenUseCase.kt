package com.example.mediaflowforreddit.domain.reddit_auth

import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity

interface RedditTokenUseCase {
    fun getAll(): List<RedditTokenEntity>
    fun insert(data: RedditTokenEntity)
    fun update(data: RedditTokenEntity)
}