package uz.mahmudxon.python_test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!Python.isStarted())
            Python.start(AndroidPlatform(this))
        val py = Python.getInstance()
        val pyf = py.getModule("myscript")
        val obj = pyf.callAttr("main")
        findViewById<TextView>(R.id.text_view).text = obj.toString()
    }
}