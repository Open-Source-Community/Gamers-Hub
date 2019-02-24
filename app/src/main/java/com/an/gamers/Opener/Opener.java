package com.an.gamers.Opener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.an.gamers.R;
import com.an.gamers.Signing.SigningActivity;

public class Opener extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout controllayout;
    OpenerAdapter openerAdapter;
    TextView dots[];
    Button finishbtn, skipbtn;
    int current_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opener);
        viewPager=findViewById(R.id.opener_view_pager);
        controllayout=findViewById(R.id.control_layout);
        openerAdapter=new OpenerAdapter(this);
        finishbtn =findViewById(R.id.opener_finishbtn);
        skipbtn =findViewById(R.id.opener_skipbtn);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opener.this.startActivity(new Intent(Opener.this, SigningActivity.class));
                Opener.this.finish();
            }
        });
       skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opener.this.startActivity(new Intent(Opener.this, SigningActivity.class));
                Opener.this.finish();
            }
        });
        viewPager.setAdapter(openerAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(viewListener);
    }
    public void addDots(int position){
        dots=new TextView [3];
        controllayout.removeAllViews();
        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;" ));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.bg_mainactivity));
            controllayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.osc_color));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
            current_page=i;
            if(i<dots.length-1){
                finishbtn.setEnabled(false);
                skipbtn.setEnabled(true);
                skipbtn.setVisibility(View.VISIBLE);
                finishbtn.setVisibility(View.INVISIBLE);
                finishbtn.setText("");
                skipbtn.setText("Skip");
            }
            else {
                finishbtn.setEnabled(true);
                skipbtn.setEnabled(false);
                finishbtn.setVisibility(View.VISIBLE);
                skipbtn.setVisibility(View.INVISIBLE);
                finishbtn.setText("Finish");
                skipbtn.setText("");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    class OpenerAdapter extends PagerAdapter{
        Context context;
        LayoutInflater layoutInflater;
        ImageView imageView;
        TextView header,description;
        String [] Headers={
                "Gaming Community","Share Your EXP","Well Designed"
        };
        String [] Descriptions={
                "Gamers Hub is a gaming community where gamers share their achievements and experiences to help one another enjoy gaming"
                ,"Share exp with the geeks community","This Application is developed and designed by powerful developers in OSC Projects Committee"
        };
        int [] Images={
                R.drawable.cooperation,R.drawable.share_exp,R.drawable.projects_icn
        };
        public OpenerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return Headers.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view== o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view= layoutInflater.inflate(R.layout.opener_slider,container,false );
            imageView=view.findViewById(R.id.opener_image);
            header=view.findViewById(R.id.opener_header);
            description=view.findViewById(R.id.opener_desc);
            imageView.setImageResource(Images[position]);
            header.setText(Headers[position]);
            description.setText(Descriptions[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout)object);
        }
    }
}
