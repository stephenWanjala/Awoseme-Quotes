package com.wtech.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wtech.quotesapp.databinding.ListOfQuotesLayoutBinding

class QuotesListAdapter(
    val myContext: Context,
    val listOfQuotesResponse:List<QuotesResponse>,
    val listener: CopyQuoteListener)
    :RecyclerView.Adapter<QuotesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
       return QuotesViewHolder(
           LayoutInflater.from(myContext)
               .inflate(R.layout.list_of_quotes_layout,parent,false)
       )
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.textQuote.text=listOfQuotesResponse[position].text
        holder.textAuthor.text=listOfQuotesResponse[position].author
        holder.buttonCopyQuoteText.setOnClickListener {
            listener.onQuoteClicked(
                listOfQuotesResponse[
                        holder.adapterPosition
                ].text
            )

        }
    }

    override fun getItemCount(): Int =listOfQuotesResponse.size
}

class QuotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    private lateinit var textQuote:TextView
//    private lateinit var textAuthor:TextView
//    private lateinit var buttonCopyQuoteText:Button
//    init {
//        val listOfQuotesLayoutBinding=ListOfQuotesLayoutBinding.bind(itemView)
//
//    }
    val textQuote:TextView=itemView.findViewById(R.id.textQuote)
    val textAuthor:TextView=itemView.findViewById(R.id.textAuthor)
    val buttonCopyQuoteText:Button=itemView.findViewById(R.id.buttonCopyQuoteText)

}