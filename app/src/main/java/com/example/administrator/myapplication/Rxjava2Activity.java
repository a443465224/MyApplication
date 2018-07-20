package com.example.administrator.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.ApiException;
import com.example.administrator.myapplication.bean.ErrorBean;
import com.example.administrator.myapplication.bean.LogUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.trello.navi2.component.NaviActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import org.apache.http.conn.ConnectTimeoutException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * Created by XDH on 2018/3/16.
 */

public class Rxjava2Activity extends NaviActivity implements View.OnClickListener {
    private TextView tv;
    private Observable<String> observable;
    Observer<String> observer;
    private String s;

    private LifecycleProvider<ActivityEvent> p =  NaviLifecycle.createActivityLifecycleProvider(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        tv = (TextView) findViewById(R.id.textView);


        findViewById(R.id.button4).setOnClickListener(this);

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                tv.setText(s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("收到错误");
            }

            @Override
            public void onComplete() {
                System.out.println("完成发送消息");
            }
        };


    }

    @Override
    public void onClick(View v) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLogInfo = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.e(message);
                if (message.startsWith("{")){
                    LogUtils.json(message);
                }
            }
        });
        httpLogInfo.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = builder.addInterceptor(httpLogInfo).build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient).build();




        String s="";
        retrofit.create(DoubanService.class).getBook()
                .subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread())
                .compose(new ObservableTransformer<ErrorBean, ErrorBean>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public ObservableSource<ErrorBean> apply(Observable<ErrorBean> upstream) {
                        if ( s== null){
                            Observable<ErrorBean> yy = Observable.error(new ApiException("这是一个异常"));
                            return Observable.error(new ApiException("这是一个异常"));
                        }
                        return upstream;
                    }
                })
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends ErrorBean>>() {
                    @Override
                    public ObservableSource<? extends ErrorBean> apply(Throwable throwable) throws Exception {
                        LogUtils.e("------onErrorRes   "+throwable.toString());


                        if (throwable instanceof UnknownHostException) {
                            LogUtils.e("网络连接错误");
                        } else if (throwable instanceof SocketTimeoutException || throwable instanceof ConnectTimeoutException) {
                            LogUtils.e("连接超时");
                        } else if (throwable instanceof HttpException) {
                            LogUtils.e("服务器错误");
                        } else if (throwable instanceof MalformedJsonException || throwable instanceof JsonSyntaxException) {
                            LogUtils.e("返回数据解析错误");
                        } else {
                            LogUtils.e("未知错误");
                        }
                        return Observable.error(new ApiException("这是一个异常"));
                    }
                })
                .filter(errorBean -> true)
               
                .subscribe(new Observer<ErrorBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(ErrorBean errorBean) {
                        LogUtils.e(true,"onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(true,"onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });





//        Observable.interval(0,1, TimeUnit.SECONDS)
//                .compose(p.bindUntilEvent(ActivityEvent.STOP))
//                .subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                LogUtils.e("Fasongshuju");
//            }
//        });


//        List<String> list =new ArrayList<>(Arrays.asList(new String[]{"1"}));
//         Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext(null);
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread())
//                .flatMap(new Function<String, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(String s) throws Exception {
//                        return null;
//                    }
//                })
//                .flatMap(s -> Observable.just(Integer.valueOf(s)))
//                .map(new Function<List<String>, String>() {
//                    @Override
//                    public String apply(List<String> strings) throws Exception {
//
//                        return null;
//                    }
//                })
//                .doOnError(new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        System.out.println("---------------"+throwable.toString());
//                    }
//                })
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("-------th--------"+e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


//
//        System.out.println("shuru-----------------");
//        Flowable<String> s = Flowable.create(new FlowableOnSubscribe<String>() {
//            @Override
//            public void subscribe(FlowableEmitter<String> e) throws Exception {
//                for (int i = 0; i < 50; i++) {
//                    e.onNext("s"+i);
//                }
//            }
//
//        }, BackpressureStrategy.ERROR);
//        s.subscribeOn(Schedulers.io());
////
////
//        Subscriber<String> stringSubscriber = new Subscriber<String>() {
//            @Override
//            public void onSubscribe(Subscription s) {
////                s.request(10);
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println("-----------------"+s);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println(t);
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        s.observeOn(Schedulers.newThread()).subscribe(stringSubscriber);
    }


    public interface DoubanService {
        @GET("article/list/100/json/")
        Observable<ErrorBean> getBook();

        @GET("n1/2018/0507/c1001-29967542.html")
        Observable<ErrorBean> testError();

    }
}
