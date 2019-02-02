package br.com.feed.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.com.feed.R
import br.com.feed.dto.FeedItem
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by willans on 02/02/19.
 */
class ItemFeedAdapter(val list: ArrayList<FeedItem>, val context: Context): RecyclerView.Adapter<ItemFeedAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.txt_title) as TextView
        val author = view.findViewById(R.id.txt_author) as TextView
        val date = view.findViewById(R.id.txt_date) as TextView
        val image = view.findViewById(R.id.img_feed) as ImageView
        val btnViewMore = view.findViewById(R.id.btn_view_more) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflate = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)

        return ItemViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder?.title?.text = list[position].title
        holder?.author?.text = list[position].author
        holder?.date?.text = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(Date(list[position].date))
        holder?.btnViewMore?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, list[position].link)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

}