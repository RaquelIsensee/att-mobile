package com.example.myapplication

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewModel.RegisterNewUserViewModel
import com.example.myapplication.viewModel.RegisterNewUserViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp()
    }
}
@Composable
fun MyApp(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val application = LocalContext.current.applicationContext as Application
    val viewModel: RegisterNewUserViewModel = viewModel(
        factory = RegisterNewUserViewModelFactory(application)
    )
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar() {
                Button(onClick = {navController.navigate("form")}){
                    Text(text = "Add")
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(paddingValues = it)) {
            OutlinedTextField(
                value =  viewModel.name,
                onValueChange = {},
                label = {
                    Text(text = "Name")
                })
            OutlinedTextField(
                value =viewModel.email,
                onValueChange = {},
                label = {
                    Text(text = "E-mail")
                })
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = {},
                label = {
                    Text(text = "Password")
                })
            Button(onClick = {
                viewModel.registrar()
            }) {
                Text(text = "Salvar")
            }
        }
    }



}