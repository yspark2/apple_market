package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarketItems(
    val img: Int,
    val title: String,
    val detail: String,
    val nickname: String,
    val price: Int,
    val addr: String,
    val chat: Int,
    var good: Int,
    var ivGood: Int,
) : Parcelable {}
