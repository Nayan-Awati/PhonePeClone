package com.example.phonepeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.phonepeclone.R
import com.example.phonepeclone.model.TransactionModel
import kotlinx.android.synthetic.main.transaction_list_item.view.*

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>(){
    private var txnList = ArrayList<TransactionModel>()
    private var ctx:Context?=null

    fun setData(arrData: ArrayList<TransactionModel>, contxt:Context){
        txnList = arrData
        ctx = contxt
    }

    public class ViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        ctx = parent.context
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.transaction_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(ctx!!).load(txnList[position].getImage()).into(holder.itemView.inv_transaction_type)
        holder.itemView.txt_transaction_date.text = txnList[position].getDate()
        holder.itemView.txt_transaction_amount.text = txnList[position].getAmount()
        holder.itemView.txt_transaction_merchant.text = txnList[position].getDealer()
        holder.itemView.txn_transaction_type.text = txnList[position].getMedium()
        holder.itemView.txn_transaction_cred_deb.text = txnList[position].getAmtCD()


    }

    override fun getItemCount(): Int {
        return txnList.size
    }


}