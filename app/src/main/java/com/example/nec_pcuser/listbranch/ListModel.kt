package com.example.nec_pcuser.listbranch

class ListModel() {

    fun getDailyItems(grade: Int):List<ListItemClass> {
        APIController.getDailyStrings(-1)
        val titles = listOf(grade.toString() + "年生:" + "移動と回転","立体図形","速さ","立体図形","総合","平面図形","微分","積分")
        val nums = listOf("No.33","No.89","No.76","No.88","No.123","No.55","No.76","No.21")
        val listItems = mutableListOf<ListItemClass>()

        for (i in titles.indices) {
            listItems.add(ListItemClass(titles[i],nums[i],0))
        }

        return listItems
    }
    fun getMonthlyItems(grade: Int):List<ListItemClass> {
        APIController.getMonthlyStrings(-1)
        val titles = listOf("マンスリー1","マンスリー2","マンスリー3")
        val nums = listOf("No.1","No.3","No.8")
        val listItems = mutableListOf<ListItemClass>()

        for (i in titles.indices) {
            listItems.add(ListItemClass(titles[i],nums[i],0))
        }

        return listItems
    }
    fun getQuestionItems(textId: Int): List<ListItemClass>{
        APIController.getQuestionStrings(textId)

        val titles = listOf("p3","p4","p5","p7","p7","p7","p11","p12")
        val nums = listOf("1番","1番","1番","1番","1番","2番","3番","1番")
        val listItems = mutableListOf<ListItemClass>()
        for (i in titles.indices) {
            listItems.add(ListItemClass(titles[i],nums[i],0))
        }
        return listItems

    }

}