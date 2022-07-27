package com.example.compose_api.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose_api.models.AlbumModel


@Composable
fun AlbumItem(albumModel: AlbumModel) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://picsum.photos/200/300")
                        .crossfade(true)
                        .build(),

                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(64.dp)
                )

                Spacer(Modifier.width(8.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)

                ) {
                    Text(
                        text = albumModel.title,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "ID: ${albumModel.id}",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "Album ID: ${albumModel.albumId}",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(3.dp)
                    )



                }
            }
        }
    }

}