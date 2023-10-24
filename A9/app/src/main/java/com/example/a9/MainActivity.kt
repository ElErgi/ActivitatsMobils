package com.example.a9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBoxMateria1 = findViewById<CheckBox>(R.id.checkBoxMateria1)
        val checkBoxMateria2 = findViewById<CheckBox>(R.id.checkBoxMateria2)
        val radioButtonManana = findViewById<RadioButton>(R.id.radioButtonManana)
        val radioButtonTarde = findViewById<RadioButton>(R.id.radioButtonTarde)

        radioButtonManana.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioButtonTarde.isChecked = false
            }
        }

        radioButtonTarde.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioButtonManana.isChecked = false
            }
        }

        // Obtener selecciones de CheckBox y RadioButton
        val materiasSeleccionadas = ArrayList<String>()
        val turnoSeleccionado = if (radioButtonManana.isChecked) "Mañana" else "Tarde"

        checkBoxMateria1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                materiasSeleccionadas.add("Materia 1")
            } else {
                materiasSeleccionadas.remove("Materia 1")
            }
        }

        checkBoxMateria2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                materiasSeleccionadas.add("Materia 2")
            } else {
                materiasSeleccionadas.remove("Materia 2")
            }
        }

        // Puedes imprimir o utilizar las selecciones como desees
        // Por ejemplo, puedes usar Logcat para imprimir las selecciones:
        materiasSeleccionadas.forEach { materia ->
            Log.d("Materias", "Materia seleccionada: $materia")
        }
        Log.d("Turno", "Turno seleccionado: $turnoSeleccionado")
    }
}