package com.example.imgdisp.adapters


import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imgdisp.R


class MyAdapter(var urls: ArrayList<String>,
                context_: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var context = context_

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
         val image: ImageView = v.findViewById(R.id.img)
         val progress:ProgressBar = v.findViewById(R.id.progress_circular)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.listitem, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("binding", "binding for -->$position")
        if(position==0)
            delayItem(holder,0,3000)
        else if(position==8)
            delayItem(holder,8,6000)
        else{
            holder.image.visibility = View.VISIBLE
            holder.progress.visibility = View.INVISIBLE
            Glide.with(context)
                .load(urls[position])
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return urls.size
    }
    
    private fun delayItem(holder: ViewHolder,position: Int, delay: Long){
        holder.image.visibility = View.INVISIBLE
        holder.progress.visibility = View.VISIBLE
        val imageView = holder.image
        Handler().postDelayed({
            holder.image.visibility = View.VISIBLE
            holder.progress.visibility = View.INVISIBLE
            Glide.with(context)
                .load(urls[position])
                .into(imageView)
            notifyItemRangeChanged(1,7)
        }, delay)
    }
}

