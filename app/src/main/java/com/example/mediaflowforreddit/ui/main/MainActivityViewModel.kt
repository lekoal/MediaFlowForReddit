package com.example.mediaflowforreddit.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity
import com.example.mediaflowforreddit.domain.reddit_auth.RedditTokenUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val redditTokenUseCase: RedditTokenUseCase
) : MainActivityContract.ViewModel() {
    override val redditTokenList: MutableLiveData<List<RedditTokenEntity>> =
        MutableLiveData<List<RedditTokenEntity>>()

    private val scopeIO = CoroutineScope(Dispatchers.IO)

    override fun getAll() {
        scopeIO.launch {
            redditTokenList.postValue(
                redditTokenUseCase.getAll()
            )
        }
    }

    override fun insert(data: RedditTokenEntity) {
        scopeIO.launch {
            redditTokenUseCase.insert(data)
        }
    }

    override fun update(data: RedditTokenEntity) {
        scopeIO.launch {
            redditTokenUseCase.update(data)
        }
    }

    override fun onCleared() {
        scopeIO.cancel()
        super.onCleared()
    }
}