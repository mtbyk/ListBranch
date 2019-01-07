package com.example.nec_pcuser.listbranch

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_text_list.*

class TextList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_list)

        val listItems = getIntent().getSerializableExtra("list") as ArrayList<ListItemClass>
        val buttonText = mutableListOf<String>()
        for (item in listItems) buttonText.add(item.buttonText)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,buttonText)
        textListView.adapter = arrayAdapter
        textListView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this,QuestionList::class.java)

            intent.putExtra("textId",listItems[position].id)
            startActivity(intent)
        }
    }
}
