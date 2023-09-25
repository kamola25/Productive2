package com.example.productive2.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productive2.data.model.PlanModel
import com.example.productive2.databinding.ItemNoteBinding
import com.example.productive2.ui.activity.MainActivity

class AdapterProd(
    private val click: MainActivity
) :RecyclerView.Adapter<AdapterProd.ViewHolderNote>(){
    private var list = ArrayList<PlanModel>()

    inner class ViewHolderNote (val binding: ItemNoteBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(noteModel: PlanModel) {
            binding.tvTitleItem.text = noteModel.title
            binding.tvDescriptionItem.text  = noteModel.description

        }

    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<PlanModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNote {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderNote(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNote, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnLongClickListener {
            click.deleteNote(list[position])
            true
        }
        holder.binding.btnEdit.setOnClickListener {
            click.updateNote(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface Result {
        fun deleteNote(model: PlanModel)
        fun updateNote(model: PlanModel)
        fun didNote(model: PlanModel)
    }

}
