package com.example.xback.inikotlin

import android.content.Context
import android.support.v7.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val Items : List<Item>)
    :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
