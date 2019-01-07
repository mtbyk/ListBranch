package com.example.nec_pcuser.listbranch

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
val DAILY_COUNT = 5
val MONTHLY_COUNT = 5

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d("dubugARG",param1)
        val v = inflater.inflate(R.layout.fragment_blank, container, false)
        val listModel = ListModel()
        val dailyItems = listModel.getDailyItems(argToGrade(param1!!))

        val dailyCardList = listOf(v.findViewById<CardView>(R.id.dailyCard1),
                v.findViewById<CardView>(R.id.dailyCard2),
                v.findViewById<CardView>(R.id.dailyCard3),
                v.findViewById<CardView>(R.id.dailyCard4),
                v.findViewById<CardView>(R.id.dailyCard5))
        val dailyNumViewList = listOf(v.findViewById<TextView>(R.id.dailyNumView1),
                v.findViewById<TextView>(R.id.dailyNumView2),
                v.findViewById<TextView>(R.id.dailyNumView3),
                v.findViewById<TextView>(R.id.dailyNumView4),
                v.findViewById<TextView>(R.id.dailyNumView5))
        val dailyButtonList = listOf(v.findViewById<TextView>(R.id.dailyButton1),
                v.findViewById<TextView>(R.id.dailyButton2),
                v.findViewById<TextView>(R.id.dailyButton3),
                v.findViewById<TextView>(R.id.dailyButton4),
                v.findViewById<TextView>(R.id.dailyButton5))
        for (count in 0 until DAILY_COUNT) {
            Log.d("debugswipe",dailyItems.lastIndex.toString())
            if (count <= dailyItems.lastIndex) {
                dailyNumViewList[count].text = dailyItems[count].num
                dailyButtonList[count].text = dailyItems[count].title
                dailyCardList[count].setOnClickListener { onButtonPressed(dailyItems[count].id)
                Log.d("qviewdebug","called")}
            } else {
                dailyCardList[count].visibility = View.GONE
            }
        }

        val monthlyItems = listModel.getMonthlyItems(argToGrade(param1!!))
        val monthlyCardList = listOf(v.findViewById<CardView>(R.id.monthlyCard1),
                v.findViewById<CardView>(R.id.monthlyCard2),
                v.findViewById<CardView>(R.id.monthlyCard3),
                v.findViewById<CardView>(R.id.monthlyCard4),
                v.findViewById<CardView>(R.id.monthlyCard5))
        val monthlyNumViewList = listOf(v.findViewById<TextView>(R.id.monthlyNumView1),
                v.findViewById<TextView>(R.id.monthlyNumView2),
                v.findViewById<TextView>(R.id.monthlyNumView3),
                v.findViewById<TextView>(R.id.monthlyNumView4),
                v.findViewById<TextView>(R.id.monthlyNumView5))
        val monthlyButtonList = listOf(v.findViewById<TextView>(R.id.monthlyButton1),
                v.findViewById<TextView>(R.id.monthlyButton2),
                v.findViewById<TextView>(R.id.monthlyButton3),
                v.findViewById<TextView>(R.id.monthlyButton4),
                v.findViewById<TextView>(R.id.monthlyButton5))
        for (count in 0 until MONTHLY_COUNT) {
            if (count <= monthlyItems.lastIndex) {
                monthlyNumViewList[count].text = monthlyItems[count].num
                monthlyButtonList[count].text = monthlyItems[count].title
                monthlyCardList[count].setOnClickListener { onButtonPressed(monthlyItems[count].id) }
            } else {
               monthlyCardList[count].visibility = View.GONE
            }
        }

        v.findViewById<Button>(R.id.toDailyListButton).setOnClickListener { onButtonPressed(dailyItems) }
        v.findViewById<Button>(R.id.toMonthlyListButton).setOnClickListener { onButtonPressed(monthlyItems) }

        return v
    }


    // TODO: Rename method, update argument and hook method into UI event
    fun argToGrade(arg: String): Int {
        when (arg.toInt()) {
            1 -> return 6
            2 -> return 5
            3 -> return 4
        }
        return 0
    }



    fun onButtonPressed(list: List<ListItemClass>) {
        listener?.onFragmentInteraction(list)
    }
    fun onButtonPressed(textId: Int) {
        listener?.onFragmentInteraction(textId)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(list: List<ListItemClass>)
        fun onFragmentInteraction(textId: Int)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BlankFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
