package com.nabila.storyapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.nabila.storyapp.R
import com.nabila.storyapp.databinding.ActivityDetailStoryBinding
import com.nabila.storyapp.view.viewmodel.MainViewModel
import com.nabila.storyapp.view.viewmodel.ViewModelFactory

class DetailStoryActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels { ViewModelFactory.getInstance(this) }
    private lateinit var binding: ActivityDetailStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = resources.getString(R.string.detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getStringExtra(EXTRA_ID).toString()

        showLoading(true)
        viewModel.getSession().observe(this) { story ->
            val token = story.token
            viewModel.getDetailStory(token, id)
        }

        viewModel.detail.observe(this) { story->
            binding.apply {
                Glide.with(this@DetailStoryActivity)
                    .load(story.photoUrl)
                    .into(previewImageView)

                name.text = story.name
                description.text = story.description
                showLoading(false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
         }
        return super.onOptionsItemSelected(item)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }

}