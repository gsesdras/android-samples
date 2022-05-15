package com.gsesdras.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.gsesdras.retrofit.extension.toReadableDate
import com.gsesdras.retrofit.model.Account
import com.gsesdras.retrofit.ui.theme.RetrofitTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    AccountList()
                }
            }
        }
    }
}

@Composable
fun AccountList() {
    val viewModel = getViewModel<MainViewModel>()
    val accounts = viewModel.accounts.collectAsState()
    viewModel.getAccounts()

    LazyColumn {
        items(
            items = accounts.value,
            key = { it.id }
        ) { account ->
            AccountCell(account)
            Divider(color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f))
        }
    }
}

@Composable
fun AccountCell(account: Account) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(64.dp)
                .width(64.dp)
                .clip(RoundedCornerShape(50))
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(account.avatarUrl)
                    .crossfade(true)
                    .build(),
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = "${account.name} avatar",
                contentScale = Fit
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
        ) {
            Text(text = account.name, style = MaterialTheme.typography.h6)
            Text(text = account.username, style = MaterialTheme.typography.body2)
            Text(text = "Since ${account.createdAt.toReadableDate()}", style = MaterialTheme.typography.caption)
        }
    }
}