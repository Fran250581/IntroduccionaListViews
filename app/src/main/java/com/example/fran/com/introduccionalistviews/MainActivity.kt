package com.example.fran.com.introduccionalistviews

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
        //val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items)

        listAdapter = arrayAdapter
        selection = findViewById<View>(R.id.elemento_seleccionado) as TextView?
    }

    /*
    override fun onListItemClick(parent: ListView, v: View, position: Int, id: Long) {
        selection!!.text = items[position]
    }
    */

    public override fun onListItemClick(parent: ListView, v: View, position: Int, id: Long) {
        val marcados = parent.checkedItemPositions
        val elementos = StringBuilder()

        if (marcados != null) {
            for (i in 0 until marcados.size()) {
                // valueAt(i) valdrá true si el ítem está marcado
                if (marcados.valueAt(i)) {
                    // keyAt(i) nos devuelve la posición del elemento
                    elementos.append(items[marcados.keyAt(i)])

                    elementos.append(" + ")
                }
            }
            elementos.delete(elementos.lastIndexOf(" + "), elementos.length - 1)
        }
        selection?.setText(elementos.toString())
    }

    companion object {
        private val items = arrayOf("En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
                "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un", "hidalgo", "de",
                "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín", "flaco", "y", "galgo", "corredor")
    }
}