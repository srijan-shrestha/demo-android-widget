package com.example.srijan_demo_widget

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService


class DemoWidgetStackService: RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return  DemoWidgetStackViewFactory(applicationContext)
    }
}

class DemoWidgetStackViewFactory(private val myContext: Context): RemoteViewsService.RemoteViewsFactory {

    var numImages: Int = 6;

    override fun onCreate() {
    }

    override fun onDataSetChanged() {
    }

    override fun onDestroy() {
    }

    override fun getCount(): Int {
        return numImages
    }

    override fun getViewAt(p0: Int): RemoteViews? {
        // inflate stack item and return
        var views = RemoteViews (myContext.packageName, R.layout.stack_item)
        var num = p0-1
        var image_id: String = "img_$num"
        Log.i("image", image_id)
        views.setImageViewResource(R.id.stack_image, myContext.resources.
        getIdentifier(image_id, "drawable", myContext.packageName))
        return views
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(p0: Int): Long {
        Log.i("int", p0.toString())
        Log.i("long", p0.toString())
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

}