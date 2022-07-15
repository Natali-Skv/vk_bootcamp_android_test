package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewsAdapter(private val dataOfReviews: List<ReviewModel>) : RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder>() {

    inner class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val avatar: ImageView = view.findViewById(R.id.avatar)
        val text: TextView = view.findViewById(R.id.text_review)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.review_item, parent, false)
        return ReviewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val reviewData = dataOfReviews[position]
        holder.name.text = reviewData.userName
        holder.avatar.setImageResource(reviewData.userImage)
        holder.date.text=reviewData.date
        holder.text.text=reviewData.message
    }


    override fun getItemCount(): Int {
        return dataOfReviews.size
    }

}


//
//class ReviewsAdapter (private val reviews: List<ReviewModel>) : RecyclerView.Adapter<ReviewsAdapter.MyViewHolder>() {
//
//
//    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
////        val reviewsRV = view.findViewById(R.id.reviewsRV)
//        val reviewsRV = view.findViewById<RecyclerView>(R.id.reviewsRV)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.review_item, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val review = reviews[position]
////        holder.reviewsRV.text = tag
// var ava =      holder.reviewsRV?.findViewById<ImageView>(R.id.avatar)
//        ava?.setImageResource(review.userImage)
////        holder.reviewsRV?.findViewById<ImageView>(R.id.avatar)?.setImageResource(review.userImage)
////        holder.reviewsRV?.text = "eeeeeeeeeeeeeeeeeeee"
//        holder.reviewsRV?.setOnClickListener {
////            onClickListener.onClicked(tag)
//        }
//    }
//
//
//    override fun getItemCount(): Int {
//        return reviews.size
//    }
//
//}