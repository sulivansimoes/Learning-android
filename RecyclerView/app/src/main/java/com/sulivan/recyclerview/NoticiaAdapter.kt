package com.sulivan.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.sulivan.recyclerview.databinding.MyItemListBinding
import org.w3c.dom.Text

class NoticiaAdapter(
    private val listaDeNoticias : List<NoticiaModel>,
    private val glide:RequestManager,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<NoticiaAdapter.ViewHolder>(){

    private lateinit var biding : MyItemListBinding

    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item){

        val titulo:TextView = biding.tituloNoticia
        val descricao:TextView = biding.textoNoticia
        val autor:TextView = biding.nomeAutor
        val autorImagem:ImageView = biding.imagemAutor
        val noticiaImagem:ImageView = biding.imagemNoticia
        val dataNoticia:TextView = biding.dataNoticia
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        biding = MyItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(biding.root)
    }

    override fun getItemCount(): Int {
        return  this.listaDeNoticias.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Pega do contrututor passado o item atual
        val itemAtual = listaDeNoticias[position]

        //Faz o DE / PARA
        holder.titulo.text = itemAtual.tituloNoticia
        holder.descricao.text = itemAtual.textoNoticia
        holder.autor.text = itemAtual.nomeAutor
        holder.dataNoticia.text = itemAtual.dataNoticia

        //Abre novo link
        holder.itemView.setOnClickListener{
            onItemClickListener.abrirLink(itemAtual.link)
        }

        //Carrrega URL usando a biblioteca Glide
        glide.load(itemAtual.imagemAutorUrl).into(holder.autorImagem)
        glide.load(itemAtual.imagemNoticia).into(holder.noticiaImagem)



    }
}