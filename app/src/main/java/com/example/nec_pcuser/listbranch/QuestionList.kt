package com.example.nec_pcuser.listbranch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_question_list.*

class QuestionList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)

        val listModel = ListModel()
        val textId = getIntent().getSerializableExtra("textId") as Int
        val listItems = listModel.getQuestionItems(textId)
        val buttonText = mutableListOf<String>()
        for (item in listItems) buttonText.add(item.buttonText)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,buttonText)
        questionListView.adapter = arrayAdapter
    }
}
