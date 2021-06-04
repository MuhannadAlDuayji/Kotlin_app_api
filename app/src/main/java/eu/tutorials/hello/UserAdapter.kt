package eu.tutorials.hello

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_item.view.*

//import eu.tutorials.apiusers.R
//import eu.tutorials.apiusers.data.Models.UserModel

//import com.squareup.picasso.Picasso

class UserAdapter (val context: Context, val items: Array<Data>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvId.text= item.id.toString()
        holder.tvFirstName.text = item.first_name
        holder.tvLastName.text = item.last_name
        holder.tvEmail.text = item.email
        Picasso.get().load(items[position].avatar).into(holder.tvImg)

    }

    override fun getItemCount()=items.size
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

        val tvId=view.tv_id
        val tvFirstName=view.tv_firstName
        val tvLastName=view.tv_lastName
        val tvEmail=view.tv_email
        val tvImg=view.iv_Img

    }
}