package com.example.nec_pcuser.listbranch

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


object APIController {
    fun getURL(videoID: Int): String {
        var videoUrl:String = "https://chugakujyuken.kobetsuba.jp/video/img_0279.trim.mov"
        videoUrl = "https://chugakujyuken.kobetsuba.jp/video/screenrecording_12-18-2018_18-43-28.mp4"

        return videoUrl
    }
    fun sendLog(time: Int) {
        /*val uid = (-1).toString()
        val db = FirebaseFirestore.getInstance()
        val data = HashMap<String, Any>()
        val docName = getTimeStamp(false)
        val date = getTimeStamp(true)

        data["action"] = time
        data["date"] = date
        db.collection("Logs").document("VideoLogs").collection("UserLog").document(uid).collection("VideoLog").document(docName).set(data)
                .addOnSuccessListener{
                    Log.d("logsenddebug", "\ndocname = " + docName + "\naction = " + time.toString() + "\ndata = " + date)
                }.addOnFailureListener{
                    Log.d("logsenddebug","failed")
                }

        //----------------debug--------------------------
        /*db.collection("Logs").document("VideoLogs").collection("UserLog").document(uid).collection("VideoLog").document("test01")
                .get()
                .addOnSuccessListener {
                    val action = it["action"] as String
                    val date = it["date"] as String
                    Log.d("logsenddub",action)
                    Log.d("logsenddub",date)
                }
                .addOnFailureListener {
                    Log.d("logsenddebug","failed")
                }*/
                */

    }
    fun getInfo(videoID: Int):MutableList<String> {
        val list:MutableList<String> = mutableListOf()
        list.add("testtext1")
        list.add("texttext2")
        list.add("testtext")
        return list
    }
    fun getTimeStamp(spaceFlag: Boolean): String {
        val df = if (spaceFlag) SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS") else SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS")
        val date = Date(System.currentTimeMillis());
        return df.format(date);
    }
    fun getDailyStrings(grade: Int) {

    }
    fun getMonthlyStrings(grade: Int) {

    }
    fun getQuestionStrings(textId: Int) {

    }

}