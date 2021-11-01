package com.alfian.githubuserapp1.ui

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.alfian.githubuserapp1.R
import com.alfian.githubuserapp1.adapter.UserAdapter
import com.alfian.githubuserapp1.databinding.ActivityMainBinding
import com.alfian.githubuserapp1.data.User

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepo: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var users = arrayListOf<User>()
    private lateinit var toolbar: Toolbar
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        setToolbar()
        prepare()
        addItem()
    }

    private fun setAdapter() {
        adapter = UserAdapter()
        with(binding) {
            rvList.adapter = adapter
            rvList.layoutManager =
                GridLayoutManager(this@MainActivity, 2, GridLayoutManager.HORIZONTAL, false)
            rvList.setHasFixedSize(true)
        }
    }

    private fun setToolbar() {
        toolbar = binding.toolbar
        toolbar.setTitleTextColor(resources.getColor(R.color.black_3333, theme))
        setSupportActionBar(toolbar)
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepo = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataCompany[position],
                dataRepo[position],
                dataFollowers[position],
                dataFollowing[position],
                dataPhoto.getResourceId(position, -1)
            )
            users.add(user)
        }
        adapter.users = users
    }
}