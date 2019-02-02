package br.com.feed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.feed.adapter.ItemFeedAdapter
import br.com.feed.dto.FeedItem
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS

class MainActivity : AppCompatActivity(), Callback {

    lateinit var recycleView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<ItemFeedAdapter.ItemViewHolder>

    private val listFeedItem = arrayListOf<FeedItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = LinearLayoutManager(this)

        recycleView = findViewById(R.id.rc_feed)
        recycleView.layoutManager = layout

        adapter = ItemFeedAdapter(listFeedItem, this)
        recycleView.adapter = adapter

        PkRSS.with(this).load("http://rss.tecmundo.com.br/feed").callback(this).async()
    }

    override fun onLoadFailed() {

    }

    override fun onPreload() {

    }

    override fun onLoaded(newArticles: MutableList<Article>?) {
        listFeedItem.clear()
        newArticles?.mapTo(listFeedItem) {
            FeedItem(it.title, it.author, it.date, it.source, it.enclosure.url)
        }

        adapter = ItemFeedAdapter(listFeedItem, this)
        adapter.notifyDataSetChanged()
    }
}
