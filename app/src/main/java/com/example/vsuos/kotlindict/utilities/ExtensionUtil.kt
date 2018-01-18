package com.example.vsuos.kotlindict.utilities

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by v.suos on 10/4/2017.
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int) : View{
    var view : View? = LayoutInflater.from(context).inflate(layoutRes, this, false)
    return view!!
}