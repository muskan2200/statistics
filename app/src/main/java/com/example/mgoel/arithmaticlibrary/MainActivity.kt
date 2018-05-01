package com.example.mgoel.arithmaticlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.statlib.CentralTendency
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers : ArrayList<Int> = ArrayList()
        val r = Random()

        for (i in 0..14) {
            numbers.add(r.nextInt(7) + 1)
        }

        val mean = CentralTendency.arithmeticMean(numbers).toDouble()
        val median = CentralTendency.median(numbers)
        val mode = CentralTendency.mode(numbers)

        Collections.sort(numbers)

        val res = String.format("Numbers:\n\n%s\nMean: %.1f\nMedian: %.1f\nMode: %s\n",
                numbers, mean, median, mode)


        textView.setText(res)
    }
}
