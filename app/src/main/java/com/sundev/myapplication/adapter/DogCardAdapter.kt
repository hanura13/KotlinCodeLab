
package com.sundev.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sundev.myapplication.R
import com.sundev.myapplication.data.DataSource
/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val vImageView: ImageView? = view!!.findViewById(R.id.list_image_vertical)
        val vTextName: TextView? = view!!.findViewById(R.id.list_name_vertical)
        val vTextAge: TextView? = view!!.findViewById(R.id.list_age_vertical)
        val vTextHobby: TextView? = view!!.findViewById(R.id.list_hobbies_vertical)

        val gImageView: ImageView? = view!!.findViewById(R.id.list_image_grid)
        val gTextNamed: TextView? = view!!.findViewById(R.id.list_name_grid)
        val gTextAge: TextView? = view!!.findViewById(R.id.list_age_grid)
        val gTextHobby: TextView? = view!!.findViewById(R.id.list_hobbies_grid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val layoutType = when(layout){
            1 -> R.layout.vertical_horizontal_list_item
            2 -> R.layout.vertical_horizontal_list_item
            else -> R.layout.grid_list_item
        }

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(layoutType, parent, false)

        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.vImageView?.setImageResource(item.imageResourceId)
        holder.gImageView?.setImageResource(item.imageResourceId)
        holder.vTextName?.text = item.name
        holder.gTextNamed?.text = item.name

        val resources = context?.resources
        holder.vTextAge?.text = resources?.getString(R.string.dog_age, item.age)
        holder.gTextAge?.text = resources?.getString(R.string.dog_age, item.age)
        holder.vTextHobby?.text = resources?.getString(R.string.dog_hobbies, item.hobbies)
        holder.gTextHobby?.text = resources?.getString(R.string.dog_hobbies, item.hobbies)
    }
}

