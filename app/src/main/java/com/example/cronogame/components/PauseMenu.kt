package com.example.cronogame.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartGameDialog(
    onDismiss: () -> Unit,
    onContinue: () -> Unit,
    onRestart: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Pausa") },
        text = { Text(text = "¿Qué deseas hacer?") },
        confirmButton = {
            Button(onClick = { onContinue() }) {
                Text(text = "Seguir juego")
            }
        },
        dismissButton = {
            Button(onClick = { onRestart() }) {
                Text(text = "Reiniciar")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewStartGameDialog() {
    val showDialog = remember { mutableStateOf(true) }

    if (showDialog.value) {
        StartGameDialog(
            onDismiss = { showDialog.value = false },
            onContinue = { showDialog.value = false },
            onRestart = { showDialog.value = false }
        )
    }
}







/*
import android.app.AlertDialog
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cronogame.R


class StartGameDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Pausa")
                .setPositiveButton("Seguir juego") { dialog, id ->
                    // START THE GAME!
                }
                .setNegativeButton("Reiniciar") { dialog, id ->
                    // User cancelled the dialog.
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

class OldXmlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)

        StartGameDialogFragment().show(supportFragmentManager, "GAME_DIALOG")
    }
}
*/