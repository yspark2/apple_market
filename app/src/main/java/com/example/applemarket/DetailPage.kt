package com.example.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applemarket.databinding.ActivityDetailPageBinding
import java.text.DecimalFormat

class DetailPage : AppCompatActivity() {

    private lateinit var binding : ActivityDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedData = intent.getParcelableExtra<MarketItems>("test")
        if (receivedData != null) {
            // 데이터 받아와서 처리
            binding.detailPageIvPicture.setImageResource(receivedData.img)
            binding.detailPageTvNickname.text = receivedData.nickname
            binding.detailPageTvAddr.text = receivedData.addr
            binding.detailPageTvTitle.text = receivedData.title
            binding.detailPageTvDetail.text = receivedData.detail
            val decimalFormat = DecimalFormat("#,###")
            binding.detailPageTvPrice.text = decimalFormat.format(receivedData.price) + "원"

        }

        binding.detailPageIvBackArrow.setOnClickListener {
            finish()
        }
    }
}