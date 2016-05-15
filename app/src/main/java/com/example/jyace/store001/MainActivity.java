package com.example.jyace.store001;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private FragmentTabHost myhost;
    private LayoutInflater layoutInflater;


    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {Fragmentt1.class,Fragment2.class,Fragment3.class,Fragment4.class,Fragment5.class};

    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.tab_home_btn,R.drawable.tab_message_btn,R.drawable.tab_selfinfo_btn,
            R.drawable.tab_square_btn,R.drawable.tab_more_btn};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "热销", "分类", "购物车", "我的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu1);
      //  toolbar.setBackground(android.R.color.background_light);

        toolbar.setNavigationIcon(R.drawable.ic_launcher);

        toolbar.setTitle(R.string.home_page);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));


   initview();

    }


    public void initview(){
        layoutInflater = LayoutInflater.from(this);
        myhost=(FragmentTabHost) this.findViewById(android.R.id.tabhost);
        myhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        int count=fragmentArray.length;
        for(int i=0;i<count;i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = myhost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            myhost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
       myhost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);




        }




    }
    public View getTabItemView(int index){


        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;




    }
}
