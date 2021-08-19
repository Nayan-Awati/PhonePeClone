package com.example.phonepeclone.model

class OfferModel (offerOn:String, offerDetails:String, image:Int){
    private var offer_on  =  offerOn
    private var offer_details = offerDetails
    private var image = image

    fun getOfferOn():String{
        return offer_on
    }
    fun setOfferOn(offerOn: String){
        offer_on=offerOn
    }
    fun getOfferDetails():String{
        return offer_details
    }
    fun setOfferDetails(offerDetails: String){
        offer_details = offerDetails
    }
    fun setImage(Image:Int){
        image = Image
    }
    fun getImage():Int{
        return image
    }

}