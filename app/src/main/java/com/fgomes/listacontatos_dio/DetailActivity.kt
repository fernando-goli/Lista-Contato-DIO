package com.fgomes.listacontatos_dio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    private var contact: Contact? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getExtras()
        bindViews()
        initToolbar()
    }

    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.tv_name).text = contact?.name
        findViewById<TextView>(R.id.tv_phone).text = contact?.phone
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}