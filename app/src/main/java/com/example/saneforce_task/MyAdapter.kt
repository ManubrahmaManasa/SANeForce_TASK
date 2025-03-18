package com.example.saneforce_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val productList:MutableList<Product>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.productName)
        val rate: TextView = view.findViewById(R.id.productRate)
        val quantity: EditText = view.findViewById(R.id.productQty)
        val total: TextView = view.findViewById(R.id.productTotal)
        val btnIncrease: Button = view.findViewById(R.id.btnIncrease)
        val btnDecrease: Button = view.findViewById(R.id.btnDecrease)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.product_name
        holder.rate.text = "${product.Rate}"
        holder.quantity.setText(product.Product_Qty.toString())
        holder.total.text = "${product.Product_Amount}"

        holder.btnIncrease.setOnClickListener {
            product.Product_Qty++
            product.Product_Amount = product.Product_Qty * product.Rate
            notifyItemChanged(position)
        }

        holder.btnDecrease.setOnClickListener {
            if (product.Product_Qty > 1) {
                product.Product_Qty--
                product.Product_Amount = product.Product_Qty * product.Rate
                notifyItemChanged(position)
            }
        }

        holder.btnDelete.setOnClickListener {
            productList.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}