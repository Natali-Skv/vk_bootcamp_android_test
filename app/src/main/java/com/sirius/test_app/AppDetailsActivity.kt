package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.sirius.test_app.databinding.AppDetailsBinding

class AppDetailsActivity : AppCompatActivity() {
    private lateinit var bindingClass: AppDetailsBinding
    private val currAppData=DataModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass=AppDetailsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.banner.setImageResource(currAppData.image)
        bindingClass.logo.setImageResource(currAppData.logo)
        bindingClass.appTitle.text=currAppData.name
        bindingClass.appUsers.text=currAppData.gradeCnt
        bindingClass.description.text=currAppData.description
        bindingClass.rating.text=currAppData.rating.toString().subSequence(0,3)
        bindingClass.reviewsCount.text=currAppData.gradeCnt

        if (currAppData.rating < 4.5) {
            bindingClass.star5.setColorFilter(R.color.gray)
            bindingClass.headerStar5.setColorFilter(R.color.gray)
        }
        if (currAppData.rating < 3.5) {
            bindingClass.star4.setColorFilter(R.color.gray)
            bindingClass.headerStar4.setColorFilter(R.color.gray)
        }
        if (currAppData.rating < 2.5) {
            bindingClass.star3.setColorFilter(R.color.gray)
            bindingClass.headerStar3.setColorFilter(R.color.gray)
        }
        if (currAppData.rating < 1.5) {
            bindingClass.star2.setColorFilter(R.color.gray)
            bindingClass.headerStar2.setColorFilter(R.color.gray)
        }
        if (currAppData.rating < 0.5)  {
            bindingClass.star1.setColorFilter(R.color.gray)
            bindingClass.headerStar1.setColorFilter(R.color.gray)
        }


        for (tagText in currAppData.tags) {
            val tagView = TextView(this, null, 0, R.style.tag)
            tagView.text = tagText
            tagView.id = View.generateViewId()
            bindingClass.rootLayout.addView(tagView)
            bindingClass.tags.addView(tagView)
        }

        createReviewsList()

    }
    private fun createReviewsList(){
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        bindingClass.reviewsRV.layoutManager = linearLayoutManager
        val adapter = ReviewsAdapter(currAppData.reviews)
        bindingClass.reviewsRV.adapter = adapter
    }
}