package com.example.app3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_bottom_second.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BottomSecondFragment : Fragment() {
    private var name_editText : EditText? = null
    private var url_editText : EditText? = null
    private var btn : Button? = null

    companion object
    {
        private var instance : BottomSecondFragment? = null

        public fun getInstance() : BottomSecondFragment
        {
            return instance!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        instance = this
        var v : View? = inflater.inflate(R.layout.fragment_bottom_second, container, false)

//        name_editText = v?.findViewById(R.id.editText)
//        url_editText = v?.findViewById(R.id.editText2)
//        btn = v?.findViewById(R.id.button)

        // Inflate the layout for this fragment
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var handler = Handler2()

        button.setOnClickListener(handler)
    }
}

class Handler2 : View.OnClickListener {
    override public fun onClick(view: View) {
        var button: Button
        var text: String

//        var name : String
//        var url : String


        if (view is Button) {
            button = view
            text = button.text.toString()

            if (text == "Submit") {
                var a = MainActivity.getInstance().editText.getText().toString()
                var b = MainActivity.getInstance().editText2.getText().toString()
                var new_channel = arrayListOf(a, b)
                var bundle = bundleOf("new_channel" to new_channel)
                println("Submitted")


                var navController = Navigation.findNavController(BottomSecondFragment.getInstance().view!!)
                navController.navigate(R.id.secondToThird, bundle)
            }
        }
    }
}