package com.biz.hello_rx


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers


import kotlin.String as String

/**
 * mainActivity에 View.OnClickListener 인터페이스를 implements하고
 * onClick
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    // observable을 등록할때 메모리 누수를 최소화 할 수 있는 도구 중의 하나
    private val disposavles: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)
        btnStop = findViewById(R.id.btn_stop)

        btnStart.setOnClickListener(this)
        btnStop.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        val viewId = v?.id // v.getId()
        var msg: String = when (viewId) {
            R.id.btn_start -> "Start"
            R.id.btn_stop -> "Stop"
            else -> "모름"

        }
        Toast.makeText(this, viewId.toString(), Toast.LENGTH_SHORT).show()

        when (viewId) {
            R.id.btn_start -> {
                this.start()
            }
        }
        fun onDestroy() {
            super.onDestroy()
            disposavles.clear()
        }
    }


    private fun start(){
        // CompositeDispsable를 이용하여 구독을 시작하겠다
        disposavles.add(
            // objservale() : 메시지를 발행하는 method
            observable()
                .subscribeOn(Schedulers.io()) // 메시지를 구독 하겠다
            .observeOn(AndroidSchedulers.mainThread()) // 메시지 구독을 mainActiviy가 작동되는
                                                        // thread에서 받겠다
                    
                // 메시지 전송이 오면
            .subscribeWith(object:DisposableObserver<String?>() {
                // 연속된 메시지가 오면, 일단 계속해서 수신하라
                // 수신된 데이터를 처리하는 부분
                override fun onNext(t: String?) {

                    Log.d("DB",t.toString())
                }

                // 메시지가 전송되는 과정에서 오류가 발생하면
                override fun onError(e: Throwable?) {
                    Log.d("DB", "Erorr")
                }

                // 메시지 방행처에서 다보냈다라고 통보가 오면
                override fun onComplete() {
                    Log.d("DB","완료")
                }


            }))
    }

    // static method
    // 메시지를 발행
    companion object {
        fun observable(): Observable<String> {
            return Observable.defer {
                Observable.just("One", "Toe", "Tree", "4", "5","6")
            }
        }
    }

}