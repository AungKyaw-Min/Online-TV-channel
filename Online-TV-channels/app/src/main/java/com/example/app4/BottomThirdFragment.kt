package com.example.app4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.Button
import android.widget.Space
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_bottom_third.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
private var channels: ArrayList<String> = arrayListOf("France24","Weather","CBS","Free Speech", "Travel", "SECDN", "Daytona", "HouseTV", "DC News","ROKU","Orange County", "Seminole County",
    "University of Texas","University of California")
private var webpages: ArrayList<String> = arrayListOf("http://static.france24.com/live/F24_EN_LO_HLS/live_web.m3u8",
    "http://weather-lh.akamaihd.net/i/twc_1@92006/master.m3u8",
    "http://cbsnewshd-lh.akamaihd.net/i/CBSNHD_7@199302/master.m3u8",
    "https://edge.free-speech-tv-live.top.comcast.net/out/u/fstv.m3u8",
    "http://media4.tripsmarter.com:1935/LiveTV/ACVBHD/chucklist.m3u8",
    "http://na-all15.secdn.net/pegstream3-live/play/c3e1e4c4-7f11-4a54-8b8f-c590a95b4ade/playlist.m3u8",
    "http://oflash.dfw.swagit.com/live/daytonabeachfl/smil:std-4x3-1-a/chucklist.m3u8",
    "http://video.oct.dc.gov/out/u/DCN.m3u8",
    "http://d3ktuc8v2sjk6m.cloudfront.net/livetv/ngrp:HouseChannel_all/chucklist.m3u8",
    "http://173.199.158.79:1935/roku/myStream/playlist.m3u8",
    "http://otv3.ocfl.net:1936/OrangeTV/smil:OrangeTV.smil/chunklist_w1007974604_b894100_sleng.m3u8",
    "http://video.seminolecountyfl.gov:1935/live/SGTV/chunklist.m3u8",
    "http://tstv-stream.tsm.utexas.edu/hls/livestream_hi/index.m3u8",
    "http://diffusionm4.assnat.qc.ca/canal9/250.sdp/playlist.m3u8")
class BottomThirdFragment : Fragment()
{


    companion object
    {
        private var instance : BottomThirdFragment? = null

        public fun getInstance() : BottomThirdFragment
        {
            return instance!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        instance = this
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        //var linearLayout1 = scrollView.findViewById<LinearLayout>(R.id.linearLayout)

        var handler = Handler1()

        var newChannel = arguments?.getStringArrayList("new_channel")
        print(newChannel?.get(0))
        if(newChannel != null) {
                if (!channels.contains(newChannel.get(0))) {
                    channels.add(newChannel.get(0))
                    webpages.add(newChannel.get(1))
                }
        }

        var space : Space
        for (i in 0..channels.size-1)
        {
            var button1 = inflate(MainActivity.getInstance(), R.layout.button, null) as Button

            var text = "Button " + i
            button1.setText(channels[i])

            button1.setOnClickListener(handler)

            linearLayout.addView(button1)

            var space = Space(MainActivity.getInstance())
            space.minimumHeight = 15
            linearLayout.addView(space)
        }
    }
}

class Handler1 : View.OnClickListener
{
    override public fun onClick(view : View)
    {
        println(view)
        var button : Button
        var text : String

        //navController.navigate(R.id.mainToSecond)

        if (view is Button)
        {
            button = view
            text = button.text.toString()


            for (i in 0 .. channels.size-1)
            {
                if(text == channels[i]) {
                    /*var webView = WebView(MainActivity.getInstance())

                //This will allow the tracing of links
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                webView.getSettings().setDomStorageEnabled(true);

                webView?.loadUrl("http://f24hls-i.akamaihd.net/hls/live/221193/F24_EN_LO_HLS/master_900.m3u8")*/

                    var url = webpages[i]
                    var bundle = bundleOf("url" to url)

                    var navController = Navigation.findNavController(BottomThirdFragment.getInstance().view!!)
                    navController.navigate(R.id.thirdToVideo, bundle)
                }
            }
        }
        //navController.navigate(R.id.mainToSecond)
    }
}
