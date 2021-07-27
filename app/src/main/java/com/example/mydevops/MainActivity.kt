package com.example.mydevops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun press (view: View){
        val label: TextView = findViewById(R.id.label)
        label.text = "Hola!!!"

        val textView = findViewById<TextView>(R.id.text)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://tsmpjgv9.000webhostapp.com/get.php?status=0&ID=1"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                val strResp = response.toString()
                label.text = strResp
            },
            Response.ErrorListener { textView.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }

}