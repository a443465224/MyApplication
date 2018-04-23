package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.ErrorBean;
import com.example.administrator.myapplication.bean.LogUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.trello.navi2.component.NaviActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
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
       observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("s1");
                e.onNext("s2");
                e.onComplete();
            }
        });
//
//        Observable<Integer> observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//            }
//        });
//
//
//        Observable<String> zip = Observable.zip(observable, observable2, new BiFunction<String, Integer, String>() {
//            @Override
//            public String apply(String s, Integer integer) throws Exception {
//
//                return null;
//            }
//        });
//
//
//        observable.filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) throws Exception {
//                return false;
//            }
//        });
//
//        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
////        com.orhanobut.logger.Logger.
//        com.orhanobut.logger.Logger.e("zhixingle");

//        LogUtils.e("zhixingle","111","32r");
        LogUtils.e(null,SystemClock.uptimeMillis(),
                SystemClock.currentThreadTimeMillis(),SystemClock.elapsedRealtime(),
                System.currentTimeMillis()
        );


        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLogInfo = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                com.orhanobut.logger.Logger.d(message);
//                LogUtils.json(message);
                LogUtils.e( message);
////                com.orhanobut.logger.Logger.d(message);
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

        retrofit.create(DoubanService.class).getBook()
                .subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("--------doOn----" + throwable.toString());
                    }
                })
                .doOnNext(new Consumer<ErrorBean>() {
                    @Override
                    public void accept(ErrorBean errorBean) throws Exception {

                        errorBean.setErrorCode(10000);
                        System.out.println("-------------doonnext----" + 10000);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("--------onComp");
                    }
                })
                .map(new Function<ErrorBean, String>() {
                    @Override
                    public String apply(ErrorBean errorBean) throws Exception {
                        System.out.println("------map----" + errorBean.getErrorCode());
                        return "111";
                    }
                })
                .compose(upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .map(s -> 22))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });




        Observable.interval(0,1, TimeUnit.SECONDS)
                .compose(p.bindUntilEvent(ActivityEvent.STOP))
                .subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                LogUtils.e("Fasongshuju");
            }
        });


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
    }
}
