package com.sulivan.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sulivan.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bidding: ActivityMainBinding
    private lateinit var listViewAdapter: ArrayAdapter<String>
    private val listaDeTarefas: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //forma mais antiga que precisa usar o FindViewById para pegar componentes da tela.
        //Dessa forma quando se tem outras telas a referencia pela forma R.layout.activity_main
        //pode gerar alguns problemas e por isso foi criado uma forma melhor/moderna que é
        //a que está sendo usada nesse código
        //> Necessario ativar o viewBinding no gradle para usar a forma presente nesse código
        //setContentView(R.layout.activity_main)

        bidding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bidding.root)

        setupListView()
        setAddButtonClickListener()
        setItemLongClick()
    }

    /**
     * Configure listView to use
     *
     */
    private fun setupListView(){
        this.bidding.lista.adapter = this.getListViewAdapter();
    }

    /**
     * initialize listviewAdpater on the first call and return, on the afters calls, returns the object initialized
     * @return listViewAdapter
     */
    private fun getListViewAdapter() : ArrayAdapter<String>{

        if ( !::listViewAdapter.isInitialized ) {

            //android.R.layout.simple_list_item_1 pega uma lista default presente nos resources do android
            //no array adapter está sendo feito o vinculo entre o array listaDeTarefas e a listView (objeto grafico)
            this.listViewAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, this.listaDeTarefas)
        }
        return this.listViewAdapter
    }

    /**
     * add actions in button Add
     */
    private fun setAddButtonClickListener(){

        bidding.button.setOnClickListener{
            val value = bidding.editTextText.text.toString()

            //Verifica se não é uma string vazia e não é nulo
            if( value.isNotBlank() ){

                listaDeTarefas.add(value)
                bidding.editTextText.text.clear()
                this.getListViewAdapter().notifyDataSetChanged()
                Toast.makeText(this, "tarefa adicionada!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Não pode adicionar vazia!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    /**
     * add action on longclick of item list
     */
    private fun setItemLongClick(){
        bidding.lista.setOnItemClickListener { _, _, position, _ ->

            //Cria uma dialog para usuário dinamicamente
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Atenção")
            alertDialog.setMessage("Você quer apagar o item?")

            alertDialog.setPositiveButton("Confirmar"){ dialog, _ ->
                this.listaDeTarefas.removeAt(position)
                this.getListViewAdapter().notifyDataSetChanged()
                dialog.dismiss()
            }

            alertDialog.setNegativeButton("Cancelar"){ dialog, _ ->
                dialog.dismiss()
            }

            alertDialog.create()
            alertDialog.show()
        }
    }
}