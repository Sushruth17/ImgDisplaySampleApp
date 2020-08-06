package com.example.imgdisp.adapters


import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.imgdisp.R
import com.squareup.picasso.Picasso
import java.security.AccessController.getContext


class MyAdapter(var urls: ArrayList<String>,
                context_: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var context = context_

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
         val image: ImageView = v.findViewById<ImageView>(R.id.img)
         val progress:ProgressBar = v.findViewById(R.id.progress_circular)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
//        v.layoutParams = RecyclerView.LayoutParams(500, 250)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("binding", "binding for -->$position")
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        if(position==8){
//            holder.getImage().setImageDrawable(context.resources.getDrawable(R.drawable.ic_ds_buffer))
            holder.image.visibility = View.INVISIBLE
            holder.progress.visibility = View.VISIBLE
            val imageView = holder.image
            Handler().postDelayed({
                holder.image.visibility = View.VISIBLE
                holder.progress.visibility = View.INVISIBLE
                if(position==8)
                Glide.with(context)
                    .load(urls[position])
                    .into(imageView)
                notifyItemRangeChanged(0,7)
            }, 3000)
        }
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
}

