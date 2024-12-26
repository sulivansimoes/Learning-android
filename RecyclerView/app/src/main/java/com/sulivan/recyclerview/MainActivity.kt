package com.sulivan.recyclerview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.sulivan.recyclerview.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var biding:ActivityMainBinding
    private var listNoticias: List<NoticiaModel> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.v(this.javaClass.simpleName, "showded oncreate")

        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        listNoticias = this.leJson(this)

        biding.recyclerView.layoutManager = LinearLayoutManager(this)
        biding.recyclerView.adapter = NoticiaAdapter(this.listNoticias, Glide.with(this), this@MainActivity)


      }

    private fun leJson(context: Context):List<NoticiaModel>{
        val listaTemp = mutableListOf<NoticiaModel>()

        Log.w(this.javaClass.simpleName, "leJson: Atenção essa operação pode resultar em uma exceção")

        try{
            val json: String = context.assets.open("data.json").bufferedReader().readText()
            val jsonArray = JSONArray(json)

            for ( i in 0 until jsonArray.length()){

                val jsonObject = jsonArray.getJSONObject(i)
                val authorName = jsonObject.getString("authorName")
                val authorImageUrl = jsonObject.getString("authorImageUrl")
                val newsImageUrl = jsonObject.getString("newsImageUrl")
                val newsTitle = jsonObject.getString("newsTitle")
                val newsDescription = jsonObject.getString("newsDescription")
                val newsDate = jsonObject.getString("newsDate")
                val link = jsonObject.getString("link")

                val noticia = NoticiaModel(
                    authorName,
                    authorImageUrl,
                    newsImageUrl,
                    newsTitle,
                    newsDescription,
                    link,
                    newsDate
                )

                Log.d(this.javaClass.simpleName, "Objeto de ${noticia.tituloNoticia} foi criado com sucesso!")
                listaTemp.add(noticia.copy())
            }
        }catch (error: Exception){
            Log.e(this.javaClass.simpleName,"Mensagem de erro:  $error")
        }

        return listaTemp
    }

    override fun abrirLink(link: String) {
        Log.i(this.javaClass.simpleName, "novo link $link aberto")
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(link)
        startActivity(intent)
    }
}
