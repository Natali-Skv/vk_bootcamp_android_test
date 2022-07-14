package com.sirius.test_app

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.sirius.test_app.databinding.AppDetailsBinding

//import

// найти все вьюшки, присвоить им текст, сорцы итд
//отрефакторить дизайн
//можносделать как будто у нас много приложений может быть , добавить функцию получения данный приложения по айди, по умолчанию поставить айди
class AppDetailsActivity : AppCompatActivity() {
    private lateinit var bindingClass: AppDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass=AppDetailsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val currAppData=DataModel()

        bindingClass.banner.setImageResource(currAppData.image)
        bindingClass.logo.setImageResource(currAppData.logo)
        bindingClass.appTitle.text=currAppData.name
        bindingClass.appUsers.text=currAppData.gradeCnt

        if (currAppData.rating < 4.5) bindingClass.star5.setColorFilter(R.color.gray)
        if (currAppData.rating < 3.5) bindingClass.star4.setColorFilter(R.color.gray)
        if (currAppData.rating < 2.5) bindingClass.star3.setColorFilter(R.color.gray)
        if (currAppData.rating < 1.5) bindingClass.star2.setColorFilter(R.color.gray)
        if (currAppData.rating < 0.5) bindingClass.star1.setColorFilter(R.color.gray)

//        bindingClass.star5.isGone=true
//        val starView=ImageView(this)
//        starView.setImageResource(R.drawable.star)
//        bindingClass.stars.addView(starView)


////        for tagText
//        val newTag = layoutInflater.inflate(R.layout.tag, null)
//        val newTag2 = layoutInflater.inflate(R.layout.tag, null)
////        val newTag3 = layoutInflater.inflate(R.layout.tag,null)
////        newTag.set
//        newTag.id = View.generateViewId()
//        newTag2.id = View.generateViewId()
////        newTag3.id = View.generateViewId()
//
//
////        bindingClass.tags.setReferencedIds(intArrayOf(newTag.id,newTag2.id,newTag3.id))
//        bindingClass.root.addView(newTag)
//        bindingClass.tags.addView(newTag)
//
//        bindingClass.root.addView(newTag2)
//        bindingClass.tags.addView(newTag2)
//
//
//        val tagView: TextView =  newTag2.findViewById(R.id.tag)
//        tagView.text= "DDDDDDDDDDDDDDDDDDDDDD"

        for (tagText in currAppData.tags) {
            var tagView = TextView(this, null, 0, R.style.tag)
            tagView.text = tagText
            tagView.id = View.generateViewId()
            bindingClass.root.addView(tagView)
            bindingClass.tags.addView(tagView)
        }


//        bindingClass.root.addView(newTag3)
//        bindingClass.tags.addView(newTag3)

//        layoutInflater.inflate(R.layout.star, bindingClass.stars)
//        layoutInflater.inflate(R.layout.star, bindingClass.stars)
//        layoutInflater.inflate(R.layout.star, bindingClass.stars)

//        bindingClass.stars.addView(view)

        // и тут отрисовываем все детальки(точнее напоняем данными)
    }
}