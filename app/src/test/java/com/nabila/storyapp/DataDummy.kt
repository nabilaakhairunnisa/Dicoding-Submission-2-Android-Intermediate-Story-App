package com.nabila.storyapp

import com.nabila.storyapp.data.response.ListStoryItem

object DataDummy {

    fun generateDummyStoryResponse(): List<ListStoryItem> {
        val items: MutableList<ListStoryItem> = arrayListOf()
        for (i in 0..100) {
            val story = ListStoryItem(
                i.toString(),
                "author + $i",
                "story $i",
            )
            items.add(story)
        }
        return items
    }
}