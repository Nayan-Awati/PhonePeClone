package com.example.phonepeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepeclone.R
import com.example.phonepeclone.model.DealerModel
import kotlinx.android.synthetic.main.list_item_dealers.view.*

class DealerAdapter: RecyclerView.Adapter<DealerAdapter.ViewHolder>() {
    private var ctx: Context?= null
    private var dealModelArrayList = ArrayList<DealerModel>()

    fun setData(contxt:Context, arrData:ArrayList<DealerModel>){
        ctx = contxt
        dealModelArrayList = arrData
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_dealers, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.dealer_txt.text = dealModelArrayList[position].getDealerName()
        holder.itemView.dealer_off.text = dealModelArrayList[position].getDis_offer()
        holder.itemView.dealer_off_price.text = dealModelArrayList[position].getDisAmt()
        holder.itemView.discount_info.text = dealModelArrayList[position].getDis_detail()
        holder.itemView.dealer_off_bw.text = dealModelArrayList[position].getDiscount_Way()


    }

    override fun getItemCount(): Int {
        return  dealModelArrayList.size

    }

}