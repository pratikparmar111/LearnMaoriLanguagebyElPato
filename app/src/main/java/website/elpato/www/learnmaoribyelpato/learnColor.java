package website.elpato.www.learnmaoribyelpato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class learnColor extends AppCompatActivity {
    ColorAdaptor itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_color);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_color);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        ArrayList<Number> numbers = GetColor();

        itemsAdapter = new ColorAdaptor(this,
                R.layout.list_view_color_item,
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
    ArrayList<Number> GetColor() {
        ArrayList<Number> numbersArrayList = new ArrayList<Number>();
        Map<Integer, String> words = GetMaoriColors();
        Map<Integer, String> Engwords = GetEnglishColors();


        for (int i = 1; i <= words.size(); i++) {
            int id = i;
            String maoriTranslation = words.get(i);
            String englishWords = Engwords.get(i);
            String icon = "icon_" + englishWords.toLowerCase();
            String audio = "audio_" + englishWords.toLowerCase();
            Number n = new Number(id, icon, maoriTranslation, audio,englishWords);
            numbersArrayList.add(n);
        }

        return numbersArrayList;
    }
    public Map<Integer, String> GetMaoriColors() {
        Map<Integer, String> words = new LinkedHashMap<>();

        words.put(1,"Kowhai");
        words.put(2,"Karaka");
        words.put(3,"Whero");
        words.put(4,"Mawhero");
        words.put(5,"Tawa");
        words.put(6,"Kikorangi");
        words.put(7,"Kakariki");
        words.put(8,"Parauri");
        words.put(9,"Kiwikiwi");
        words.put(10,"Ma");
        words.put(11,"Mangu");

        return words;
    }
    public Map<Integer, String> GetEnglishColors() {
        Map<Integer, String> words = new LinkedHashMap<>();

        words.put(1,"Yellow");
        words.put(2,"Orange");
        words.put(3,"Red");
        words.put(4,"Pink");
        words.put(5,"Purple");
        words.put(6,"Blue");
        words.put(7,"Green");
        words.put(8,"Brown");
        words.put(9,"Grey");
        words.put(10,"White");
        words.put(11,"Black");

        return words;
    }
}
