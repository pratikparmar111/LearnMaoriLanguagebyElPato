package website.elpato.www.learnmaoribyelpato;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for setting image icon in header
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        CardView cardNumbers1 = (CardView) findViewById(R.id.card_one);
        cardNumbers1.setOnClickListener(CardNumbersHandler1);

        CardView cardNumbers2 = (CardView) findViewById(R.id.card_two);
        cardNumbers2.setOnClickListener(CardNumbersHandler2);

        CardView cardNumbers3 = (CardView) findViewById(R.id.card_three);
        cardNumbers3.setOnClickListener(CardNumbersHandler3);
    }

       // Intent numbersActivity = new Intent(getBaseContext(), NumbersActivity.class);
       // startActivity(numbersActivity);


    View.OnClickListener CardNumbersHandler1 = new View.OnClickListener() {

        boolean visible ;
        public void onClick(View v) {
            Intent numbersActivity = new Intent(getBaseContext(), NumbersActivity.class);
            startActivity(numbersActivity);
            overridePendingTransition(R.anim.slide_down_in,R.anim.fade_out);
        }
    };
    View.OnClickListener CardNumbersHandler2 = new View.OnClickListener() {
        public void onClick(View view) {
            Intent learnFamilyName = new Intent(getBaseContext(), learnFamilyName.class);
            startActivity(learnFamilyName);
            overridePendingTransition(R.anim.slide_down_in,R.anim.fade_out);

        }
    };
    View.OnClickListener CardNumbersHandler3 = new View.OnClickListener() {
        public void onClick(View view) {

            Intent learnColor = new Intent(getBaseContext(), learnColor.class);
            startActivity(learnColor);
            overridePendingTransition(R.anim.slide_down_in,R.anim.fade_out);
        }
    };



}