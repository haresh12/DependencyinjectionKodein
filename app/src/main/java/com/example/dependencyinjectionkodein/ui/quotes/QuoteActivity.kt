package com.example.dependencyinjectionkodein.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dependencyinjectionkodein.R
import com.example.dependencyinjectionkodein.data.model.Qoute
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.lang.StringBuilder

class QuoteActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()

    private val factory: QuoteViewModelFactory  by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi() {
        val provider = ViewModelProviders.of(this as FragmentActivity, factory).get(QouteViewModel::class.java)
        provider.getQuote().observe(this, Observer { qoute ->
            val builder = StringBuilder()
            qoute.forEach { qoute ->
                builder.append("$qoute\n\n")
            }
            textView_quotes.text = builder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Qoute(editText_quote.text.toString(), editText_author.text.toString())
            provider.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }

}
