package com.example.todo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.todo.R
import com.example.todo.databinding.ItemChildBinding
import com.example.todo.databinding.ItemParentBinding
import com.example.todo.models.KompInfo

class ModelAdapter(var list:ArrayList<String>, var map: HashMap<String, ArrayList<KompInfo>>):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return list.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[list[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return list[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[list[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
       val itemParent = ItemParentBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemParent.tvParent.text = list[groupPosition]
        itemParent  .image.setOnClickListener {
            itemParent.image.setImageResource(R.drawable.down)
        }
        return itemParent.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
       val itemChild = ItemChildBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemChild.tvChild.text = map[list[groupPosition]]?.get(childPosition).toString()
        return itemChild.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}