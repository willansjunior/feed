package br.com.feed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.feed.dto.FeedItem
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS

class MainActivity : AppCompatActivity(), Callback {

    val listFeedItem = arrayListOf<FeedItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PkRSS.with(this).load("http://rss.tecmundo.com.br/feed").callback(this).async()
    }

    override fun onLoadFailed() {

    }

    override fun onPreload() {

    }

    override fun onLoaded(newArticles: MutableList<Article>?) {
        newArticles?.mapTo(listFeedItem) {
            FeedItem(it.title, it.author, it.date, it.source, it.enclosure.url)
        }
    }
}
