package br.com.feed.dto

import android.net.Uri

/**
 * Created by willans on 02/02/19.
 */
data class FeedItem(val title: String, val author: String, val date: Long, val link: Uri, val image: String)