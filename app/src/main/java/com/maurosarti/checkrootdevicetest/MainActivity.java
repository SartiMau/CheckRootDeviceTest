package com.maurosarti.checkrootdevicetest;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maurosarti.checkrootdevicetest.RootBeer.RootBeer;
import com.maurosarti.checkrootdevicetest.RootBeer.util.Utils;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RootBeer rootBeer;
    private TextView isRootedText;
    private Button button;
    private Drawable redCross;
    private Drawable greenTick;

    private ArrayList<ImageView> checkRootImageViewList;

    boolean customCheck1;
    boolean customCheck2;
    boolean customCheck3;
    boolean customCheck4;

    boolean rootCheck1;
    boolean rootCheck2;
    boolean rootCheck3;
    boolean rootCheck4;
    boolean rootCheck5;
    boolean rootCheck6;
    boolean rootCheck7;
    boolean rootCheck8;
    boolean rootCheck9;
    boolean rootCheck10;
    boolean rootCheck11;

    ImageView customCheck1ImageView;
    ImageView customCheck2ImageView;
    ImageView customCheck3ImageView;
    ImageView customCheck4ImageView;

    ImageView rootCheck1ImageView;
    ImageView rootCheck2ImageView;
    ImageView rootCheck3ImageView;
    ImageView rootCheck4ImageView;
    ImageView rootCheck5ImageView;
    ImageView rootCheck6ImageView;
    ImageView rootCheck7ImageView;
    ImageView rootCheck8ImageView;
    ImageView rootCheck9ImageView;
    ImageView rootCheck10ImageView;
    ImageView rootCheck11ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        rootBeer = new RootBeer(this);
        isRootedText = findViewById(R.id.text);
        button = findViewById(R.id.button);

        redCross = this.getResources().getDrawable(R.drawable.ic_cross_red_24dp);
        greenTick = this.getResources().getDrawable(R.drawable.ic_tick_green_24dp);

        customCheck1ImageView = findViewById(R.id.content_main_custom_check_image_1);
        customCheck2ImageView = findViewById(R.id.content_main_custom_check_image_2);
        customCheck3ImageView = findViewById(R.id.content_main_custom_check_image_3);
        customCheck4ImageView = findViewById(R.id.content_main_custom_check_image_4);

        rootCheck1ImageView = findViewById(R.id.content_main_root_check_image_1);
        rootCheck2ImageView = findViewById(R.id.content_main_root_check_image_2);
        rootCheck3ImageView = findViewById(R.id.content_main_root_check_image_3);
        rootCheck4ImageView = findViewById(R.id.content_main_root_check_image_4);
        rootCheck5ImageView = findViewById(R.id.content_main_root_check_image_5);
        rootCheck6ImageView = findViewById(R.id.content_main_root_check_image_6);
        rootCheck7ImageView = findViewById(R.id.content_main_root_check_image_7);
        rootCheck8ImageView = findViewById(R.id.content_main_root_check_image_8);
        rootCheck9ImageView = findViewById(R.id.content_main_root_check_image_9);
        rootCheck10ImageView = findViewById(R.id.content_main_root_check_image_10);
        rootCheck11ImageView = findViewById(R.id.content_main_root_check_image_11);

        checkRootImageViewList = new ArrayList<>();
        checkRootImageViewList.add(customCheck1ImageView);
        checkRootImageViewList.add(customCheck2ImageView);
        checkRootImageViewList.add(customCheck3ImageView);
        checkRootImageViewList.add(customCheck4ImageView);

        checkRootImageViewList.add(rootCheck1ImageView);
        checkRootImageViewList.add(rootCheck2ImageView);
        checkRootImageViewList.add(rootCheck3ImageView);
        checkRootImageViewList.add(rootCheck4ImageView);
        checkRootImageViewList.add(rootCheck5ImageView);
        checkRootImageViewList.add(rootCheck6ImageView);
        checkRootImageViewList.add(rootCheck7ImageView);
        checkRootImageViewList.add(rootCheck8ImageView);
        checkRootImageViewList.add(rootCheck9ImageView);
        checkRootImageViewList.add(rootCheck10ImageView);
        checkRootImageViewList.add(rootCheck11ImageView);

        button.setOnClickListener(v -> {
            resetRootCheckImages();

            Observable.create(emitter -> {

                customCheck1 = RootUtils.checkRootMethod1();
                customCheck2 = RootUtils.checkRootMethod2();
                customCheck3 = RootUtils.checkRootMethod3();
                customCheck4 = RootUtils.checkRootMethod4();

                rootCheck1 = rootBeer.detectRootManagementApps();
                rootCheck2 = rootBeer.detectPotentiallyDangerousApps();
                rootCheck3 = rootBeer.detectTestKeys();
                rootCheck4 = rootBeer.checkForBusyBoxBinary();
                rootCheck5 = rootBeer.checkForSuBinary();
                rootCheck6 = rootBeer.checkSuExists();
                rootCheck7 = rootBeer.checkForRWPaths();
                rootCheck8 = rootBeer.checkForDangerousProps();
                rootCheck9 = rootBeer.checkForRootNative();
                rootCheck10 = Utils.isSelinuxFlagInEnabled();
                rootCheck11 = rootBeer.checkForMagiskBinary();

                emitter.onNext(true);
                emitter.onComplete();

            }).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(new DefaultObserver<Object>() {
                        @Override
                        public void onNext(Object o) {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            customCheck1ImageView.setImageDrawable(customCheck1 ? redCross : greenTick);
                            customCheck2ImageView.setImageDrawable(customCheck2 ? redCross : greenTick);
                            customCheck3ImageView.setImageDrawable(customCheck3 ? redCross : greenTick);
                            customCheck4ImageView.setImageDrawable(customCheck4 ? redCross : greenTick);

                            rootCheck1ImageView.setImageDrawable(rootCheck1 ? redCross : greenTick);
                            rootCheck2ImageView.setImageDrawable(rootCheck2 ? redCross : greenTick);
                            rootCheck3ImageView.setImageDrawable(rootCheck3 ? redCross : greenTick);
                            rootCheck4ImageView.setImageDrawable(rootCheck4 ? redCross : greenTick);
                            rootCheck5ImageView.setImageDrawable(rootCheck5 ? redCross : greenTick);
                            rootCheck6ImageView.setImageDrawable(rootCheck6 ? redCross : greenTick);
                            rootCheck7ImageView.setImageDrawable(rootCheck7 ? redCross : greenTick);
                            rootCheck8ImageView.setImageDrawable(rootCheck8 ? redCross : greenTick);
                            rootCheck9ImageView.setImageDrawable(rootCheck9 ? redCross : greenTick);
                            rootCheck10ImageView.setImageDrawable(rootCheck10 ? redCross : greenTick);
                            rootCheck11ImageView.setImageDrawable(rootCheck11 ? redCross : greenTick);

                            boolean isRooted = false;
                            for (ImageView imageView : checkRootImageViewList) {
                                if(imageView.getDrawable() == redCross){
                                    isRooted = true;
                                    break;
                                }
                            }
                            if(isRooted) {
                                isRootedText.setText("Esta rooteado!!");
                                isRootedText.setTextColor(Color.RED);
                            } else {
                                isRootedText.setText("No esta rooteado!!");
                                isRootedText.setTextColor(Color.rgb(26, 145, 11));
                            }
                        }
                    });
        });
    }

    private void resetRootCheckImages() {
        isRootedText.setText("RESULTADO");
        for (ImageView imageView : checkRootImageViewList) {
            imageView.setImageDrawable(null);
        }
    }
}
