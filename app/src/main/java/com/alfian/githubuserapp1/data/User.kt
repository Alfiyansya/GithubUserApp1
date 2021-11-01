package com.alfian.githubuserapp1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    var username: String,
    var name: String,
    var location: String,
    var company: String,
    var repository: String,
    var followers: String,
    var following: String,
    var photo:Int,
): Parcelable