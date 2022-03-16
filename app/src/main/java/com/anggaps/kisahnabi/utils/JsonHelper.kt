package com.anggaps.kisahnabi.utils

import android.content.Context
import com.anggaps.kisahnabi.data.source.remote.response.StoryListResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class JsonHelper(private val context :Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

//    fun loadCourses(): List<CourseResponse> {
//        val list = ArrayList<CourseResponse>()
//        try {
//            val responseObject = JSONObject(parsingFileToString("CourseResponses.json").toString())
//            val listArray = responseObject.getJSONArray("courses")
//            for (i in 0 until listArray.length()) {
//                val course = listArray.getJSONObject(i)
//
//                val id = course.getString("id")
//                val title = course.getString("title")
//                val description = course.getString("description")
//                val date = course.getString("date")
//                val imagePath = course.getString("imagePath")
//
//                val courseResponse = CourseResponse(id, title, description, date, imagePath)
//                list.add(courseResponse)
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        return list
//    }

    fun loadStory():List<StoryListResponse>{
        val list = ArrayList<StoryListResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("Story.json").toString())
            val listArray = responseObject.getJSONArray("story")

            for (i in 0 until listArray.length()) {
                val story = listArray.getJSONObject(i)

                val id =story.getString("id")
                val title =story.getString("titleName")
                val turun =story.getString("turun")
                val desc = story.getString("desc")
                val imagePath = story.getString("imagePath")


                val storyResponse = StoryListResponse(id, title,turun, desc, imagePath)

                list.add(storyResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }




}