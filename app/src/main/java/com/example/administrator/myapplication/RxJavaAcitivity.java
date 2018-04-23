package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/6/7.
 */

public class RxJavaAcitivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
//    private Observable<Bitmap> from;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);


        bt1 = (Button) findViewById(R.id.button4);
        bt1.setOnClickListener(this);

//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);




    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button4:



//                Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        System.out.println(Thread.currentThread().getId());
//                        subscriber.onNext("test");
//                        subscriber.onCompleted();
//                    }
//                });
//
//
//                Subscriber<String> subscriber = new Subscriber<String>() {
//
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println(Thread.currentThread().getId());
//                        System.out.println("收到的消息："+s);
//                    }
//                };
//
//                observable.subscribe(subscriber);


//                Observable<Bitmap> from = Observable.just(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/1Log/source.jpg")
//                        .map(new Func1<String, Bitmap>() {
//                            @Override
//                            public Bitmap call(String s) {
//                                Bitmap bitmap = BitmapFactory.decodeFile(s);
//
//
//                                return bitmap;
//                            }
//                        });

//                Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
//
////                Observable<Long> interval = Observable.timer(3,TimeUnit.SECONDS);
//                interval.filter(new Func1<Long, Boolean>() {
//                    @Override
//                    public Boolean call(Long aLong) {
//                        System.out.println("fllter处理：  "+aLong.toString());
//                        return aLong == 7;
//                    }
//                }).subscribe(new Subscriber<Long>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        System.out.println(aLong.toString());
//                        if (aLong == 10) {
//                            unsubscribe();
//                            System.out.println("jiechu");
//                        }
//                    }
//                });

//                Observable.create(new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        subscriber.onNext("1");
//                        subscriber.onNext("2");
//                        System.out.println("create:" + Thread.currentThread().getId());
//                    }
//                })
//                        .observeOn(Schedulers.io())
//                        .subscribeOn(Schedulers.io())
//                        .map(new Func1<String, Integer>() {
//                            @Override
//                            public Integer call(String s) {
//                                System.out.println("map" + Thread.currentThread().getId());
//                                Integer integer = Integer.valueOf(s);
//                                return integer;
//                            }
//                        })
//                        .observeOn(Schedulers.io())
//                        .filter(new Func1<Integer, Boolean>() {
//                            @Override
//                            public Boolean call(Integer integer) {
//                                System.out.println("filter" + Thread.currentThread().getId());
//                                return integer == 2;
//                            }
//                        })
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Action1<Integer>() {
//                            @Override
//                            public void call(Integer integer) {
//                                System.out.println("subscribe" + Thread.currentThread().getId());
//
//                            }
//                        });
//
//
//                new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//                };


//                AsyncSubject<String> asyncSubject = AsyncSubject.create();
//                asyncSubject.onNext("asyncSubject1");
//                asyncSubject.onNext("asyncSubject2");
//                asyncSubject.onNext("asyncSubject3");
////                asyncSubject.onCompleted();
//                asyncSubject.subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                        System.out.println("asyncSubject onCompleted");  //输出 asyncSubject onCompleted
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                        System.out.println("asyncSubject onError");  //不输出（异常才会输出）
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                        System.out.println("asyncSubject:"+s);  //输出asyncSubject:asyncSubject3
//                    }
//                });




//                BehaviorSubject<String> behaviorSubject = BehaviorSubject.create("default");
////                behaviorSubject.onNext("behaviorSubject1");
////                behaviorSubject.onNext("behaviorSubject2");
//                behaviorSubject.subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                        System.out.println("behaviorSubject:complete");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                        System.out.println("behaviorSubject:error");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                        System.out.println("behaviorSubject:"+s);
//                    }
//                });
//
//                behaviorSubject.onNext("behaviorSubject3");
//                behaviorSubject.onNext("behaviorSubject4");


//                ReplaySubject<String> replaySubject = ReplaySubject.create(); //创建默认初始缓存容量大小为16的ReplaySubject，当数据条目超过16会重新分配内存空间，使用这种方式，不论ReplaySubject何时被订阅，Observer都能接收到数据
//replaySubject = ReplaySubject.create(100);//创建指定初始缓存容量大小为100的ReplaySubject
//                ReplaySubject<String>   replaySubject = ReplaySubject.createWithSize(1);//只缓存订阅前最后发送的2条数据
////replaySubject=ReplaySubject.createWithTime(1,TimeUnit.SECONDS,Schedulers.computation());  //replaySubject被订阅前的前1秒内发送的数据才能被接收
//                replaySubject.onNext("replaySubject:pre1");
//                replaySubject.onNext("replaySubject:pre2");
//                replaySubject.onNext("replaySubject:pre3");
//                replaySubject.subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println("replaySubject:" + s);
//                    }
//                });
//                replaySubject.onNext("replaySubject:after1");
//                replaySubject.onNext("replaySubject:after2");
//                replaySubject.onNext("replaySubject:after4");
//                replaySubject.onNext("replaySubject:after5");




//                Observable<WeaterBean.ResultBean> observable = Observable.just(new WeaterBean())3
//                        .flatMap(new Func1<WeaterBean, Observable<WeaterBean.ResultBean>>() {
//                    @Override
//                    public Observable<WeaterBean.ResultBean> call(WeaterBean weaterBean) {
//                        Observable.from(weaterBean.getResult());
//                        return null;
//                    }
//                });


//                java.util.Calendar instance = java.util.Calendar.getInstance();
//                long now = instance.getTimeInMillis();
//                instance.set(1991,8,12);
//                long before = instance.getTimeInMillis();
//                long age = now-before;
//                System.out.println(age/1000/3600/24/365f);



//                Subscriber<Bitmap> subscriber = new Subscriber<Bitmap>() {
//
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//                    @Override
//                    public void onNext(Bitmap s) {
//                        bt1.setBackground(new BitmapDrawable(s));
//                    }
//                };

//                from.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(subscriber);


                break;
        }
    }
}
