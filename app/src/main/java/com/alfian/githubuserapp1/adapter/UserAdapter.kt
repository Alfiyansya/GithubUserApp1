package com.alfian.githubuserapp1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.alfian.githubuserapp1.data.User
import com.alfian.githubuserapp1.databinding.ItemUserBinding
import com.alfian.githubuserapp1.ui.DetailActivity
import com.bumptech.glide.Glide

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    var users = arrayListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(users[position])

    override fun getItemCount(): Int = users.size

    class MyViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.name.text = user.name
            binding.username.text = user.username
            Glide.with(binding.root)
                .load(user.photo)
                .circleCrop()
                .into(binding.circleImageView)
            binding.root.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.KEY_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }
}
