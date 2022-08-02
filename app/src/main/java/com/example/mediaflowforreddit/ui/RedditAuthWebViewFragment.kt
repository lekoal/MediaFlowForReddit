package com.example.mediaflowforreddit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mediaflowforreddit.R

class RedditAuthWebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reddit_auth_web_view, container, false)
    }

    companion object {
        fun newInstance() = RedditAuthWebViewFragment()
    }
}