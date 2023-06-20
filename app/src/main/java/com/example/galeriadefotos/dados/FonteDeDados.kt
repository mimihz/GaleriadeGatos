package com.example.galeriadefotos.dados

import com.example.galeriadefotos.R
import com.example.galeriadefotos.model.IdImagemDescricao

class FonteDeDados {

    fun carregaListaMolduras():List<IdImagemDescricao>{

        return listOf<IdImagemDescricao>(
            IdImagemDescricao(R.drawable.gaaaatoooooo,R.string.gatoooo),
            IdImagemDescricao(R.drawable.gato_pretomimindo,R.string.gato_dormindo),
            IdImagemDescricao(R.drawable.gatoassustado,R.string.gato_assustado),
            IdImagemDescricao(R.drawable.gatobravo,R.string.gato_bravo),
            IdImagemDescricao(R.drawable.gatocurioso,R.string.gato_curioso),
            IdImagemDescricao(R.drawable.gatofofocando,R.string.gatos_fofocando),
            IdImagemDescricao(R.drawable.gatobebendo,R.string.gato_bebendo_café),
            IdImagemDescricao(R.drawable.gatocomendomilho,R.string.gatos_comendo_milho),
        )

    }
}