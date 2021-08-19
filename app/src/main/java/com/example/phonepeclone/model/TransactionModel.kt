package com.example.phonepeclone.model

class TransactionModel(txnDate:String, txnMed:String, txnDealer:String,
                        txnAmt:String, txnAmtCD:String, imgTxnWay:Int) {
    private var txn_date = txnDate
    private var txn_med = txnMed
    private var txn_dealer = txnDealer
    private var txn_amt = txnAmt
    private var txn_amt_cd = txnAmtCD
    private var img_txn_way = imgTxnWay

    fun setDate(date:String){
        txn_date = date
    }
    fun getDate():String{
        return txn_date
    }
    fun setMedium(medium:String){
        txn_med = medium
    }
    fun getMedium():String{
        return txn_med
    }
    fun setDealer(dealerName:String){
        txn_dealer = dealerName
    }
    fun getDealer():String{
        return txn_dealer
    }
    fun setAmount(amt:String){
        txn_amt = amt
    }
    fun getAmount():String{
        return txn_amt
    }
    fun setAmtCD(amtcd:String){
        txn_amt_cd = amtcd
    }
    fun getAmtCD():String{
        return txn_amt_cd
    }
    fun setImage(img:Int){
        img_txn_way = img
    }
    fun getImage():Int{
        return img_txn_way
    }
}