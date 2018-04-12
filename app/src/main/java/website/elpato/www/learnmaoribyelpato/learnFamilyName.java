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

public class learnFamilyName extends AppCompatActivity {
    FamilyAdaptor itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_family_name);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_family);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ArrayList<Number> numbers = GetFamily();

        itemsAdapter = new FamilyAdaptor(this,
                R.layout.list_view_family_item,
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
    ArrayList<Number> GetFamily() {
        ArrayList<Number> numbersArrayList = new ArrayList<Number>();
        Map<Integer, String> words = GetMaoriFamily();
        Map<Integer, String> Engwords = GetEnglishFamily();
        //Map<Integer, String> words = GetGujaratiDigits();

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
    public Map<Integer, String> GetMaoriFamily() {
        Map<Integer, String> words = new LinkedHashMap<>();
        words.put(1,"Pāpā");
        words.put(2,"Whaea");
        words.put(3,"Wahine");
        words.put(4,"Tāne");
        words.put(5,"Tamaiti");
        words.put(6,"Tamariki");
        words.put(7,"Tamāhine");
        words.put(8,"Tama");
        words.put(9,"Tungāne");
        words.put(10,"Tuahine");
        words.put(11,"Tipuna wahine");
        words.put(12,"Tupuna tāne");
        words.put(13,"Kotiro");
        words.put(14,"Pepi");
        return words;
    }
    public Map<Integer, String> GetEnglishFamily() {
        Map<Integer, String> words = new LinkedHashMap<>();
        words.put(1,"Father");
        words.put(2,"Mother");
        words.put(3,"Wife");
        words.put(4,"Husband");
        words.put(5,"Child");
        words.put(6,"Children");
        words.put(7,"Daughter");
        words.put(8,"Son");
        words.put(9,"Brother");
        words.put(10,"Sister");
        words.put(11,"Grandmother");
        words.put(12,"Grandfather");
        words.put(13,"Girl");
        words.put(14,"Baby");
        return words;
    }

}
