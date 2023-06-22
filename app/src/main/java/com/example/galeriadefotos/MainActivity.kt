package com.example.galeriadefotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriadefotos.dados.FonteDeDados
import com.example.galeriadefotos.model.IdImagemDescricao
import com.example.galeriadefotos.ui.theme.GaleriaDeFotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppGaleriaDeFotos()
                }
            }
        }
    }
}
@Preview
@Composable
fun AppGaleriaDeFotos(){
    LazyColumn( ){
        items(FonteDeDados().carregaListaMolduras()){
            molduraImagemDescricao -> MolduraImagemDescricao(molduraImagemDescricao )
        }
    }
}


@Composable
fun MolduraImagemDescricao(idImagemDescricao:IdImagemDescricao){

    var expandir by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(7.dp)
            .animateContentSize (
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessMedium
                )
                    )
    ) {
        Column() {
            Image(
                painter = painterResource(id = idImagemDescricao.idImagem),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(400.dp)
                    .aspectRatio(30f / 30f)
                    .padding(30.dp)
                    .clickable {
                        expandir = !expandir
                    }
            )
            Text(
                text = stringResource(id = idImagemDescricao.idDescricao),
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .fillMaxSize(),
            )
            if (expandir==true)
                    Text(
                        text = "ME DA COMIDA"
                    )


        }
    }
}

@Preview
@Composable
fun PreviewMoldura(){


//    Column() {
//        MolduraImagemDescricao(
//            idImagem = R.drawable.imagem2,
//            idDescricao = R.string.descricao_imagem2
//        )
//        MolduraImagemDescricao(
//            idImagem = R.drawable.imagem1,
//            idDescricao = R.string.descricao_imagem1
//        )
//    }

}