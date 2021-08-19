package com.example.phonepeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.phonepeclone.model.OfferModel
import com.example.phonepeclone.R
import kotlinx.android.synthetic.main.list_item_offers.view.*
import kotlinx.android.synthetic.main.transaction_list_item.view.*

class OfferAdapter: RecyclerView.Adapter<OfferAdapter.ViewHolder>() {
    private var offerModelArrayList = ArrayList<OfferModel>()
    private var ctx: Context?=null

    fun setData(contxt:Context, arrData:ArrayList<OfferModel>){
        offerModelArrayList = arrData
        ctx = contxt
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_offers,  parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(ctx!!).load(offerModelArrayList[position].getImage()).into(holder.itemView.offer_img)
        holder.itemView.offer_text.text = offerModelArrayList[position].getOfferOn()
        holder.itemView.offer_info.text = offerModelArrayList[position].getOfferDetails()

    }

    override fun getItemCount(): Int {
       return  offerModelArrayList.size

    }
}