package com.example.mediaflowforreddit.di

import androidx.room.Room
import com.example.mediaflowforreddit.data.local.reddit_auth.RedditTokenUseCaseImpl
import com.example.mediaflowforreddit.data.local.reddit_auth.dao.RedditTokenDao
import com.example.mediaflowforreddit.data.local.reddit_auth.database.RedditTokenDatabase
import com.example.mediaflowforreddit.domain.reddit_auth.RedditTokenUseCase
import com.example.mediaflowforreddit.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val koinRedditTokenDBModule = module {
    single<RedditTokenDatabase>(named("reddit_token_data_base")) {
        Room.databaseBuilder(
            get(),
            RedditTokenDatabase::class.java,
            "reddit_token"
        )
            .build()
    }
    single<RedditTokenDao>(named("reddit_token_dao")) {
        get<RedditTokenDatabase>(
            named("reddit_token_data_base")
        )
            .redditTokenDao()
    }
    single<RedditTokenUseCase>(named("reddit_token_usecase")) {
        RedditTokenUseCaseImpl(get(named("reddit_token_dao")))
    }
    viewModel(named("main_activity_view_model")) {
        MainActivityViewModel(
            get(named("reddit_token_usecase"))
        )
    }
}