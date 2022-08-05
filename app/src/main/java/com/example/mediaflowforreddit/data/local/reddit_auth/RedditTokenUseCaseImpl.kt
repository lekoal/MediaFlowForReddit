package com.example.mediaflowforreddit.data.local.reddit_auth

import com.example.mediaflowforreddit.data.local.reddit_auth.dao.RedditTokenDao
import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity
import com.example.mediaflowforreddit.domain.reddit_auth.RedditTokenUseCase

class RedditTokenUseCaseImpl(private val redditTokenDao: RedditTokenDao) : RedditTokenUseCase {
    override fun getAll(): List<RedditTokenEntity> {
        return redditTokenDao.getAll()
    }

    override fun insert(data: RedditTokenEntity) {
        redditTokenDao.insert(data)
    }

    override fun update(data: RedditTokenEntity) {
        redditTokenDao.update(data)
    }
}