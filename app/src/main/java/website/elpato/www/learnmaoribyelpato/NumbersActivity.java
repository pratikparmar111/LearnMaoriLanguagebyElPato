package website.elpato.www.learnmaoribyelpato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumbersActivity extends AppCompatActivity {

    NumberAdaptor itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_number);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ArrayList<Number> numbers = GetNumbers();

                itemsAdapter = new NumberAdaptor(this,
                R.layout.lis_view_number_item,
                numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Adding rotate animation to the Play Button to provide emphasis
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final ImageView playImgaeView = (ImageView) view.findViewById(R.id.image_view_play);
                //to rotate image on touch
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(500);
                rotate.setInterpolator(new LinearInterpolator());;
                playImgaeView.startAnimation(rotate);

            }
        });
    }

    ArrayList<Number> GetNumbers() {
        ArrayList<Number> numbersArrayList = new ArrayList<Number>();
        Map<Integer, String> words = GetMaoriDigits();
        Map<Integer, String> Engwords = GetEnglishDigits();
        //Map<Integer, String> words = GetGujaratiDigits();

        for (int i = 1; i <= words.size(); i++) {
            int id = i;
            String maoriTranslation = words.get(i);
            String englishWords = Engwords.get(i);
            String icon = "icon" + id;
            String audio = "audio_" + id;
            Number n = new Number(id, icon, maoriTranslation, audio,englishWords);
            numbersArrayList.add(n);
        }

        return numbersArrayList;
    }
    public Map<Integer, String> GetEnglishDigits() {
        Map<Integer, String> words = new LinkedHashMap<Integer, String>();
        words.put(1, "One");
        words.put(2, "Two");
        words.put(3, "Three");
        words.put(4, "Four");
        words.put(5, "Five");
        words.put(6, "Six");
        words.put(7, "Seven");
        words.put(8, "Eight");
        words.put(9, "Nine");
        words.put(10,"Ten");
        return words;
    }
    public Map<Integer, String> GetMaoriDigits() {
        Map<Integer, String> words = new LinkedHashMap<Integer, String>();
        words.put(1, "Tahi");
        words.put(2, "Rua");
        words.put(3, "Toru");
        words.put(4, "Wha");
        words.put(5, "Rima");
        words.put(6, "Ono");
        words.put(7, "Whitu");
        words.put(8, "Waru");
        words.put(9, "Iwa");
        words.put(10,"Tekau");
        return words;
    }/*
    public Map<Integer, String> GetGujaratiDigits() {
        Map<Integer, String> words = new LinkedHashMap<Integer, String>();
        words.put(1, "એક");
        words.put(2, "બે");
        words.put(3, "ત્રણ");
        words.put(4, "ચાર");
        words.put(5, "પાંચ");
        words.put(6, "છ");
        words.put(7, "સાત");
        words.put(8, "આઠ");
        words.put(9, "નવ");
        words.put(10,"દસ");

        return words;
    }*/

}
