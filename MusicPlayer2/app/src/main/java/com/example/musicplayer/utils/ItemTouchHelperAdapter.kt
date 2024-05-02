package com.example.musicplayer.utils


interface ItemTouchHelperAdapter {
    fun onItemMoved(fromPosition:Int, toPosition:Int)
    fun onItemDismiss(position:Int)
}