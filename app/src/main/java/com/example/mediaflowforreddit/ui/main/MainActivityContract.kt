package com.example.mediaflowforreddit.ui.main

import androidx.lifecycle.LiveData
import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity

interface MainActivityContract {
    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract val redditTokenList: LiveData<List<RedditTokenEntity>>
        abstract fun getAll()
        abstract fun insert(data: RedditTokenEntity)
        abstract fun update(data: RedditTokenEntity)
    }
}