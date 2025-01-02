package com.example.fashionshop.features.account.profile.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.size.Size.Companion.ORIGINAL
import com.example.fashionshop.R
import com.example.fashionshop.di.Paddings
import com.example.fashionshop.features.account.profile.domain.ProfileViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun AccountScreen(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val user = viewModel.user.collectAsStateWithLifecycle()

    if (Firebase.auth.currentUser == null) {
        Log.i("INFO", Firebase.auth.toString())
        navController.navigate("login") {
            popUpTo("login") { inclusive = true }
        }
    } else {
        Log.i("INFO", Firebase.auth.currentUser?.uid.toString())

        viewModel.getUserInfo()

        val painter1 = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(user.value.imageUri)
                .size(ORIGINAL)
                .build(),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Paddings.innerPadding),
//            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.profile),
                style = MaterialTheme.typography.titleLarge,
            )
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .heightIn(240.dp)
                            .fillMaxWidth(0.5f),
                        painter = painter1,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                        modifier = Modifier
                            .height(340.dp)
                            .padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(user.value.name)
                        Text(user.value.surname)
                    }
                }
            }
            Spacer(Modifier.height(32.dp))
            Button(onClick = { Firebase.auth.signOut() }) {
                Text("Press me")
            }
        }
    }
}