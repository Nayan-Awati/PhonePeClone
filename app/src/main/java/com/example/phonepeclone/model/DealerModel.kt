package com.example.phonepeclone.model

class DealerModel(dealerName: String, disOffer:String, disAmt:String, disWay:String,
                    disDetail: String) {
    var dealer_Name: String = dealerName
    var discount_offer: String = disOffer
    var discount_amt: String = disAmt
    var discount_way: String = disWay
    var discount_detail: String = disDetail


    fun getDealerName():String{
        return dealer_Name
    }
    fun setDealerName(dealer_name:String){
        dealer_Name = dealer_name
    }

    fun getDisAmt():String{
        return discount_amt
    }
    fun setDis_amt(discountAmt:String){
        discount_amt = discountAmt
    }
    fun getDiscount_Way():String{
        return discount_way
    }
    fun setDis_way(discountWay: String){
        discount_way = discountWay
    }
    fun getDis_offer():String{
        return discount_offer
    }
    fun setDis_offer(discountOffer:String){
        discount_offer = discountOffer
    }
    fun getDis_detail():String{
        return discount_detail
    }
    fun setDis_detail(discountDetail:String){
        discount_detail = discountDetail
    }



}