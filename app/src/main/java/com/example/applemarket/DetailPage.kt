package com.example.applemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.applemarket.databinding.ActivityDetailPageBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class DetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var receivedData = intent.getParcelableExtra<MarketItems>("data")
        if (receivedData != null) {
            // 데이터 받아와서 처리
            binding.detailPageIvPicture.setImageResource(receivedData.img)
            binding.detailPageTvNickname.text = receivedData.nickname
            binding.detailPageTvAddr.text = receivedData.addr
            binding.detailPageTvTitle.text = receivedData.title
            binding.detailPageTvDetail.text = receivedData.detail
            val decimalFormat = DecimalFormat("#,###")
            binding.detailPageTvPrice.text = decimalFormat.format(receivedData.price) + "원"

            // 좋아요 구현
            binding.detailPageIvLike.setImageResource(receivedData.ivGood)

        }



        binding.detailPageIvLike.setOnClickListener {

            val currentImageResource = binding.detailPageIvLike.drawable
            val isLike = currentImageResource.constantState == resources.getDrawable(
                R.mipmap.love_empty,
                null
            ).constantState
            val position = intent.getIntExtra("position", 0)
//            Toast.makeText(this, "포지션 값 : $position", Toast.LENGTH_SHORT).show()
            if (isLike) {
                binding.detailPageIvLike.setImageResource(R.mipmap.love_fill)
                showSnackbar("관심 목록에 추가되었습니다.")
                intent.putExtra("goodCnt", position)
                intent.putExtra("goodImg", R.mipmap.love_fill)
            } else {
                binding.detailPageIvLike.setImageResource(R.mipmap.love_empty)
                intent.putExtra("goodCnt", position)
                intent.putExtra("goodImg", R.mipmap.love_empty)
            }
            setResult(RESULT_OK, intent)
        }

        binding.detailPageIvBackArrow.setOnClickListener {
            finish()
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }
}