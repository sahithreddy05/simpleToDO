package android.example.simpletodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//bridge that tells the recyclerview how to display the data we give it
class TaskItemAdapter(val listOfItems:List<String>,val longClickListener: OnLongClickListener) :
    RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {

    interface OnLongClickListener {
        fun onItemLongClicked(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflator = LayoutInflater.from(context)
        val contactView = inflator.inflate(android.R.layout.simple_list_item_1,parent,false)

        return  ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//   Get data  model based on position
        val item = listOfItems.get(position)

        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return  listOfItems.size
    }

    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        // store references to elements to our layout
         val textView : TextView

        init{
            textView = itemView.findViewById(android.R.id.text1)

            itemView.setOnLongClickListener {
                longClickListener.onItemLongClicked(adapterPosition)
                true
            }
        }
    }
}