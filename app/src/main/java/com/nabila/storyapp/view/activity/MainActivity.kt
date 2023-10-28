package com.nabila.storyapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nabila.storyapp.R
import com.nabila.storyapp.databinding.ActivityMainBinding
import com.nabila.storyapp.view.adapter.LoadingStateAdapter
import com.nabila.storyapp.view.adapter.StoryAdapter
import com.nabila.storyapp.view.viewmodel.MainViewModel
import com.nabila.storyapp.view.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels { ViewModelFactory.getInstance(this) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStory.layoutManager = LinearLayoutManager(this)

        showLoading(true)
        viewModel.getSession().observe(this) { user ->
            val token = user.token
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
            getData(token)
        }

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, UploadActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getData(token: String) {
        val adapter = StoryAdapter()
        binding.rvStory.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )
        viewModel.getStories(token).observe(this) {
            adapter.submitData(lifecycle, it)
            showLoading(false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            viewModel.logout()
        }
        if (item.itemId == R.id.maps) {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}