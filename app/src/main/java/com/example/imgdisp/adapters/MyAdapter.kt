package com.example.imgdisp.adapters


import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imgdisp.R


class MyAdapter(var urls: ArrayList<String>,
                context_: Context ) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var context = context_

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
         val image: ImageView = v.findViewById(R.id.img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.listitem, parent, false)

        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("binding", "binding for -->$position")
        if(position==8) {
            Handler().postDelayed({
                Glide.with(context)
                    .load(urls[position])
                    .into(holder.image)
                notifyItemRangeChanged(0,8)
            }, 5000)
        }
        else{
            Glide.with(context)
                .load(urls[position])
                .into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return urls.size
    }
}

