package com.vaibhavrawat.toastandtypes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var btnShort: Button? = null
    var btnLong: Button? = null
    var btnIndefinite: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShort = findViewById(R.id.btnShort)
        btnLong = findViewById(R.id.btnLong)
        btnIndefinite = findViewById(R.id.btnIndefinite)
        btnShort?.setOnClickListener {
            btnShort?.let {
                Snackbar.make(it, "Snack bar for short time.", Snackbar.LENGTH_SHORT).show()
                    //.setAction("Clear") {
                       // Toast.makeText(this, "DATA CLEARED SUCCESSFULLY", Toast.LENGTH_SHORT)
                     //       .show()
                   // } .show()
            }

            btnLong?.setOnClickListener {
                btnLong?.let {
                    Snackbar.make(it, "Snack bar for long time.", Snackbar.LENGTH_LONG).show()
                        //.setAction("Clear") {
                          //  Toast.makeText(this, "DATA CLEARED SUCCESSFULLY", Toast.LENGTH_SHORT)
                            //    .show()
                        //} .show()
                }
            }

            btnIndefinite?.setOnClickListener {
                btnIndefinite?.let {
                    Snackbar.make(it, "Snack bar for Indefinite time until you press OK", Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK") {
                            Toast.makeText(this, "OK is pressed!", Toast.LENGTH_SHORT)
                                .show()
                        } .show()
                }
            }
        }
    }
}