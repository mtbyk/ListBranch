package com.example.nec_pcuser.listbranch

class ListItemClass(val title: String, val num: String, val id: Int): java.io.Serializable {
    val buttonText = num + "-" + title
}