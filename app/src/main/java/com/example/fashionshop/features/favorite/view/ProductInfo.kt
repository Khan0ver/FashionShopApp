package com.example.fashionshop.features.favorite.view

data class ProductInfo(
    val name: String,
    val shortDescription: String,
    val imageUri: String,
)

val productInfoTestList = listOf(
    ProductInfo(
        name = "Shrek hat",
        shortDescription = "Cool hat, bro",
        imageUri = "https://i5.walmartimages.com/seo/European-and-American-hand-woven-wool-adult" +
                "-green-Shrek-color-hat_487b71da-46e7-47e1-8682-25a77266a854" +
                ".01758b48f6f5b56816e865ceaee267f1.jpeg"
    ),
    ProductInfo(
        name = "Shrek jacket",
        shortDescription = "100% fashion",
        imageUri = "https://i.ebayimg.com/images/g/WqwAAOSw25ZjSbFC/s-l1200.jpg"
    ),
    ProductInfo(
        name = "Shrek pants",
        shortDescription = "100% synthetic",
        imageUri = "https://storage.vsemayki.ru/images/0/3/3766/3766577/previews/" +
                "people_1_man_trousers_back_black_500.jpg"
    ),
    ProductInfo(
        name = "Shrek shoes",
        shortDescription = "beautiful and gorgeous",
        imageUri = "https://img.gazeta.ru/files3/210/17549210/" +
                "sub-buzz-605-1694023403-2-pic4_zoom-1500x1500-25095.jpg"
    ),
)
