package polbeng.ac.id.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val runnable = Worker()
            val thread = Thread(runnable)
            thread.start()
        }
    }
    inner class Worker : Runnable {
        override fun run() {
            killSomeTime()
        }
    }
    private fun killSomeTime() {
        for (i in 1..20) {
            var msg = Message.obtain()
            msg.data.putString("counter", i.toString())
            Thread.sleep(2000)

        }
    }
}