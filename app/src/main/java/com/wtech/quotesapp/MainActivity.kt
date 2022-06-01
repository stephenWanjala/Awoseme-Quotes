package com.wtech.quotesapp

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wtech.quotesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var progressBarDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        RequestManager(this@MainActivity)
            .GetAllQuotes(listener)
        progressBarDialog=ProgressDialog(this@MainActivity)
           progressBarDialog .setTitle("Loading ...")
        progressBarDialog.show()
    }
    private val listener=object :QuotesResponseListener{
        override fun didAfetch(response: List<QuotesResponse>, mesaage: String) {
           progressBarDialog.dismiss()
            val recyclerViewAdapter=QuotesListAdapter(this@MainActivity,response)
            binding.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                adapter=recyclerViewAdapter

            }

        }

        override fun didError(message: String) {
            progressBarDialog.dismiss()
            Toast.makeText(this@MainActivity,
            message,Toast.LENGTH_LONG)
                .show()
        }

    }
}