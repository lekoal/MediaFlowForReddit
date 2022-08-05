package com.example.mediaflowforreddit.data.local.reddit_auth

object RedditAuthData {
    const val CLIENT_ID = "7nrvqb1yTALaJTVvlmxTxg"
    const val REDIRECT_URI = "http://www.example.com/my_redirect"
    private const val STRING_LENGTH = 12
    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val STATE = (1..STRING_LENGTH)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
    private const val INDEX_LENGTH = 8
    val INDEX = (1..INDEX_LENGTH)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
    const val ACCESS_TOKEN_URL = "https://www.reddit.com/api/v1/access_token"
    val AUTH_URL = "https://www.reddit.com/api/v1/authorize.compact?client_id=" +
            "$CLIENT_ID&response_type=code&state=$STATE&redirect_uri=$REDIRECT_URI&" +
            "duration=permanent&scope=identity"
}