package mx.edu.potros.examenu1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import mx.itson.edu.examenu1.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoC: TextView = findViewById(R.id.editTextC)
        val campoF: TextView = findViewById(R.id.editTextF)
        val btnC: Button = findViewById(R.id.btnC)
        val btnF: Button = findViewById(R.id.btnF)

        btnC.setOnClickListener {
            var gradosF: Double = 0.0

            try {
                gradosF = campoF.text.toString().toDouble()
            } catch (e: java.lang.Exception) {
                println(e)
            }

            var gradosC = calcularGradosC(gradosF)
            val formattedNumber = "%.2f".format(gradosC)
            campoC.setText(formattedNumber)
        }

        btnF.setOnClickListener {
            var gradosC: Double = 0.0

            try {
                gradosC = campoC.text.toString().toDouble()
            } catch (e: java.lang.Exception) {
                println(e)
            }

            var gradosF = calcularGradosF(gradosC)
            val formattedNumber = "%.2f".format(gradosF)
            campoF.setText(formattedNumber)
        }
    }

    fun calcularGradosC(gradosF: Double): Double {
        return (gradosF - 32) / 1.8
    }

    fun calcularGradosF(gradosC: Double): Double {
        return gradosC * 1.8 + 32
    }
}