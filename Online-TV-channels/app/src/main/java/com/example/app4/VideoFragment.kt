package com.example.app4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import kotlinx.android.synthetic.main.fragment_video.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class VideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        //Getting URL
        var newURL = arguments?.getString("url")
        print(newURL.toString())

        val settings = webView.getSettings()
        settings.setJavaScriptEnabled(true)
        settings.setDomStorageEnabled(true) //save lots of data
        settings.setMinimumFontSize(10)
        settings.setLoadWithOverviewMode(true)
        settings.setUseWideViewPort(true)
        settings.setBuiltInZoomControls(true)
        settings.setDisplayZoomControls(false)
        webView.setVerticalScrollBarEnabled(false)
        settings.setDomStorageEnabled(true)
        webView.setWebChromeClient(WebChromeClient())
        //webView.loadUrl("http://f24hls-i.akamaihd.net/hls/live/221193/F24_EN_LO_HLS/master_900.m3u8")

        //Loading URL from argument
        webView.loadUrl(newURL.toString())

        //ADD CODE HERE
    }


}
