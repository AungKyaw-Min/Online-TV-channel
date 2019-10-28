package com.example.app4
//
//import kotlinx.android.synthetic.main.fragment_bottom_main.*
//
//class Slideshow : Thread{
//    var duration : Int = 0;
//
//    constructor(duration: Int) {
//        this.duration = duration
//    }
//    public override fun run() {
//        var imageArray = listOf("image1", "image2", "image3")
//        var count = 0
//        while(true)
//        {
//            var handler = SlideShowHandler(imageArray[count])
//            MainActivity.getInstance().runOnUiThread(handler)
//            Thread.sleep(duration.toLong()*1000) //Delay
//
//            count++
//            if(count >= imageArray.size){
//                count = 0
//            }
//        }
//    }
//}
//
//class SlideShowHandler : Runnable
//{
//    private var fn : String = ""
//
//    constructor(fn: String)
//    {
//        this.fn = fn
//    }
//
//    override fun run()
//    {
//        var imageView = BottomMainFragment.getInstance().imageView
//        var id = BottomMainFragment.getInstance().resources.getIdentifier(fn, "drawable", MainActivity.getInstance().packageName)
//        imageView.setImageResource(id)
//    }
//}