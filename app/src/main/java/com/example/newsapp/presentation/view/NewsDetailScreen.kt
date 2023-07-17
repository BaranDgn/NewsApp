package com.example.newsapp.presentation.view



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.newsapp.R

@Composable
fun NewsDetailScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

       Image(
           painter = rememberImagePainter(data = R.drawable.ic_launcher_foreground),
           contentDescription = "",
           modifier = Modifier
               .padding(vertical = 8.dp)
               .fillMaxWidth()
               .height(200.dp)
       )

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "NEWs Title", fontWeight = FontWeight.SemiBold, fontSize = 24.sp ,modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "NEWs Detail", fontWeight = FontWeight.Normal, fontSize = 20.sp ,modifier = Modifier.fillMaxSize())
        }





    }

}