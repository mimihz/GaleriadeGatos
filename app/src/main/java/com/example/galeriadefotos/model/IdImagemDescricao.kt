package com.example.galeriadefotos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class IdImagemDescricao(
    @DrawableRes val idImagem:Int,
    @StringRes val idDescricao:Int
)
