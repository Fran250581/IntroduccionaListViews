package com.example.fran.com.introduccionalistviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ArrayAdapter
import android.app.ListActivity
import android.view.View
import android.widget.ListView

class MainActivity : ListActivity() {
    private var selection: TextView? = null

    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)
        val arrayAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                items)

        listAdapter = arrayAdapter
        selection = findViewById<View>(R.id.elemento_seleccionado) as TextView?
    }

    override fun onListItemClick(parent: ListView, v: View, position: Int,
                                 id: Long) {
        selection!!.text = items[position]
    }

    companion object {
        private val items = arrayOf("En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un", "hidalgo", "de", "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín", "flaco", "y", "galgo", "corredor")
    }
}