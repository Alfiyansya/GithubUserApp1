package com.alfian.githubuserapp1.adapter

import com.alfian.githubuserapp1.data.User

interface OnItemClickCallback {
    fun onItemClicked(user : User)
}