package com.example.jyace.store001;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Jyace on 2016/5/13.
 */
public class CNToolbar extends Toolbar {
EditText editText;
    TextView textView;
    ImageButton imageButton;

    private LayoutInflater layoutInflater;
public CNToolbar(Context context){
    this(context,null);

}

    public CNToolbar(Context context, AttributeSet attributeSet){
       this(context,attributeSet,0);

    }
    public CNToolbar(Context context,AttributeSet attributeSet,int defStyleLatter){
        super(context,attributeSet,defStyleLatter);
initview();
    }

private void initview(){
   View view= layoutInflater.inflate(R.layout.toolbar,null);
editText=(EditText)findViewById(R.id.searchviewtoolbar);
    textView=(TextView)findViewById(R.id.textview);
    imageButton=(ImageButton)findViewById(R.id.toolbar_rightbutton);
LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
addView(view,layoutParams);

}



}
