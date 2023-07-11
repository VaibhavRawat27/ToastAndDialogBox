package com.vaibhavrawat.toastandtypes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var btnShort: Button? = null
    var btnLong: Button? = null
    var btnIndefinite: Button? = null
    var btnAlertDialog : Button?= null
    var tvDisplayData : TextView?= null
    var tvDisplayNumber : TextView?= null
    var num = 0
    var btnAlertSelection : Button?=null
    var btnMultipleSelection : Button?=null
    var list= arrayOf("Kotlin","JAVA","C#")
    var name = ""//arrayOf<String>("")
    var booleanList = booleanArrayOf(false,false,false)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShort = findViewById(R.id.btnShort)
        btnLong = findViewById(R.id.btnLong)
        btnIndefinite = findViewById(R.id.btnIndefinite)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        tvDisplayNumber = findViewById(R.id.tvDisplayNumber)
        btnAlertSelection = findViewById(R.id.btnAlertSelection)
        btnMultipleSelection = findViewById(R.id.btnMultipleSelection)
        tvDisplayData = findViewById(R.id.tvDisplayData)
        btnAlertDialog?.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Testing alert!")
            alert.setMessage("Message is passed")
            alert.setCancelable(false)
            alert.setPositiveButton("ADD 2"){_,_->
                Toast.makeText(this, "2 is added successfully!", Toast.LENGTH_SHORT).show()
                num += 2
                tvDisplayNumber?.text=num.toString()
            }
            alert.setNegativeButton("SUB 2"){_,_->
                Toast.makeText(this, "2 is deleted successfully!", Toast.LENGTH_SHORT).show()
                num -= 2
                tvDisplayNumber?.text=num.toString()
            }
            alert.setNeutralButton("SET 0"){_,_->
                Toast.makeText(this, "Clear to 0", Toast.LENGTH_SHORT).show()
                tvDisplayNumber?.text=0.toString()
                num = 0
            }
            alert.show()
        }
        btnAlertSelection?.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("List Selection")
            alert.setCancelable(false)
            alert.setItems(list) { _, position ->
                var name1 = list[position]
                tvDisplayData?.text = name1.toString()
                Toast.makeText(this, "You selected : ${list[position]}", Toast.LENGTH_SHORT).show()
            }
            alert.show()
        }

        btnMultipleSelection?.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Multi choice list selection")
            alert.setCancelable(false)
            alert.setMultiChoiceItems(list,booleanList){_, position, isChecked ->
                for (i in 0..(list.size-1)) {
                    if (booleanList[i]) {
                        name = list[position]
                        //print(name[i])
                    }
                }
                Toast.makeText(this,"You selected : ${list[position]},$isChecked",Toast.LENGTH_SHORT).show()
            }
            alert.setPositiveButton("Submit"){_,_ ->
                Toast.makeText(this,"Data submitted",Toast.LENGTH_SHORT).show()
              //  for (i in 0..(list.size-1)) {
                    tvDisplayData?.text = name
                    // print(tvDisplayData)
                }
            alert.show()
            }
        
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
