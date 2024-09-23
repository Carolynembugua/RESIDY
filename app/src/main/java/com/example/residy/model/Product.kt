package com.example.residy.models

class Product {
    var name:String = ""
    var type:String = ""
    var price:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, type: String, price: String,phone: String, imageUrl: String, id: String) {
        this.name = name
        this.type = type
        this.price = price
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}