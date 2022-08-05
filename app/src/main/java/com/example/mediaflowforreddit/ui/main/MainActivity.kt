package com.example.mediaflowforreddit.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mediaflowforreddit.data.local.reddit_auth.RedditAuthData
import com.example.mediaflowforreddit.data.local.reddit_auth.entities.RedditTokenEntity
import com.example.mediaflowforreddit.databinding.ActivityMainBinding
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONException
import org.json.JSONObject
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import java.io.IOException
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private const val ERROR_TAG = "ERROR_TAG"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by
    inject<MainActivityViewModel>(named("main_activity_view_model"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAll()
        startSignIn()
    }

    override fun onResume() {
        super.onResume()
        if (intent != null && intent.action.equals(Intent.ACTION_VIEW)) {
            val uri: Uri = intent.data!!
            if (uri.getQueryParameter("error") != null) {
                Log.e(ERROR_TAG, "Error: ${uri.getQueryParameter("error")}")
            } else {
                val state = uri.getQueryParameter("state")
                if (state.equals(RedditAuthData.STATE)) {
                    val code = uri.getQueryParameter("code")
                    getAccessToken(code)
                }
            }
        }
    }

    private fun getAccessToken(code: String?) {
        val client = OkHttpClient()
        val authString = "${RedditAuthData.CLIENT_ID}:"
        val encodedAuthString = Base64.encodeToString(
            authString.encodeToByteArray(),
            Base64.NO_WRAP
        )
        val request = Request.Builder()
            .addHeader("User-Agent", "Media Flow")
            .addHeader("Authorization", "Basic $encodedAuthString")
            .url(RedditAuthData.ACCESS_TOKEN_URL)
            .post(
                ("grant_type=authorization_code&code" +
                        "=$code&redirect_uri" +
                        "=${RedditAuthData.REDIRECT_URI}"
                        ).toRequestBody("application/x-www-form-urlencoded".toMediaTypeOrNull())
            )
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(ERROR_TAG, "Error: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string().toString()
                lateinit var data: JSONObject
                try {
                    data = JSONObject(json)
                    val accessToken = data.optString("access_token")
                    val refreshToken = data.optString("refresh_token")
                    val currentDateTime = LocalDateTime.now().toString()
                    val currentToken = RedditTokenEntity(
                        accessToken = accessToken,
                        refreshToken = refreshToken,
                        tokenDateTime = currentDateTime
                    )
                    Log.i("MY_TAG", currentToken.toString())
                    viewModel.insert(currentToken)
                } catch (e: JSONException) {
                    Log.e(ERROR_TAG, "JSON error: $e")
                    e.printStackTrace()
                }
            }
        })
    }

    private fun startSignIn() {
        viewModel.redditTokenList.observe(this) { tokenList ->
            if (tokenList.isEmpty()) {
                val url = RedditAuthData.AUTH_URL
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }

    private fun stringToLocalDate(value: String): LocalDateTime {
        return LocalDateTime.parse(value)
    }

    private fun tokenDateCompare(dateOld: LocalDateTime): Long {
        val dateNow = LocalDateTime.now()
        return dateOld.until(dateNow, ChronoUnit.HOURS)
    }
}