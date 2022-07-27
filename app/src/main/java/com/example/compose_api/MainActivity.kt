package com.example.compose_api



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_api.models.AlbumModel
import com.example.compose_api.ui.theme.Compose_apiTheme
import com.example.compose_api.view.AlbumItem
import com.example.compose_api.viewModel.AlbumViewModel


class MainActivity : ComponentActivity() {

    private val albumViewModel by viewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_apiTheme {

                Surface(color = MaterialTheme.colors.background) {
                    AlbumList(albumList = albumViewModel.albumListResponse)
                    albumViewModel.getDataList()

                }
            }
        }
    }
}

@Composable
fun AlbumList(albumList: List<AlbumModel>) {
    LazyColumn {
        itemsIndexed(items = albumList) { index, item ->
            AlbumItem(albumModel = item)
        }
    }
}
