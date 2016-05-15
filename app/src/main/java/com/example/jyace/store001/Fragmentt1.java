package com.example.jyace.store001;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.List;

/**
                     * Created by Jyace on 2016/5/13.
                     */
public class Fragmentt1 extends Fragment {
    SliderLayout sliderShow;



    private List<Product> productList;
    PagerIndicator indicator;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        sliderShow = (SliderLayout) view.findViewById(R.id.slider);
        indicator = (PagerIndicator) view.findViewById(R.id.custom_indicator);
         RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        RecycleItemClickListener itemClickListener = new RecycleItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Log.e("position","="+position);
             Toast.makeText(Fragmentt1.this.getActivity(), "暂时缺货", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent();
                //intent.setClass(getActivity(), ProductDetailActivity.class);
                //startActivity(intent);
            }
        };
        initdata();
        MasonryAdapter adapter = new MasonryAdapter(productList, itemClickListener);

        recyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);

        initslider();
        return view;
    }

    private void initdata() {
        productList = new ArrayList<Product>();
        Product p1 = new Product(R.mipmap.le1s1, "乐视1s玫瑰金");
        productList.add(p1);
        Product p2 = new Product(R.mipmap.le2, "千元旗舰乐视二代");
        productList.add(p2);
        Product p3 = new Product(R.mipmap.hm1, "红米note2");
        productList.add(p3);
        Product p4 = new Product(R.mipmap.mpro, "魅族pro1");
        productList.add(p4);
        Product p5 = new Product(R.mipmap.xmi5, "骁龙820xiaomi5");
        productList.add(p5);
        Product p6 = new Product(R.mipmap.meilan, "青年良品魅蓝note");
        productList.add(p6);
        Product p7 = new Product(R.drawable.le2max, "双6时代乐max2");
        productList.add(p7);
        Product p8 = new Product(R.drawable.le3, "未来科技乐视3");
        productList.add(p8);
        Product p9 = new Product(R.drawable.le2pro, "乐二pro升级力作");
        productList.add(p9);
        Product p10 = new Product(R.drawable.le2max2, "乐max2骁龙820");
        productList.add(p10);
        Product p11 = new Product(R.drawable.mate7, "国产巅峰商务Mate8");
        productList.add(p11);
        Product p12 = new Product(R.drawable.mi51, "小米5");
        productList.add(p12);
        Product p13 = new Product(R.drawable.mi4, "M4经典");
        productList.add(p13);
        Product p14 = new Product(R.drawable.mi3, "M3大降价");
        productList.add(p14);

    }

    public void initslider() {


        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView
                .description("LeTv2Pro")
                .image(R.drawable.le2pro);
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(Fragmentt1.this.getActivity(), "乐视手机二代，千元旗舰", Toast.LENGTH_LONG).show();
            }
        });
        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .description("LeTv2Max")
                .image(R.drawable.le2max);
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(Fragmentt1.this.getActivity(), "乐视手机二代，Pro之王", Toast.LENGTH_LONG).show();
            }
        });
        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3
                .description("LeTv1s")
                .image(R.drawable.le1s1);
        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(Fragmentt1.this.getActivity(), "乐视手机LeMax2，独孤求败", Toast.LENGTH_LONG).show();
            }
        });
        TextSliderView textSliderView4 = new TextSliderView(this.getActivity());
        textSliderView4
                .description("XiaoMi5")
                .image(R.mipmap.xmi5);
        textSliderView4.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(Fragmentt1.this.getActivity(), "史上最大屏小米手机", Toast.LENGTH_LONG).show();
            }
        });
        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);
        sliderShow.addSlider(textSliderView4);
        //sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderShow.setCustomIndicator(indicator);
        sliderShow.setCustomAnimation(new DescriptionAnimation());
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Tablet);
        sliderShow.setDuration(3000);
        sliderShow.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}


