package website.elpato.www.learnmaoribyelpato;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.CalendarContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Dell on 11/14/2017.
 */

public class ColorAdaptor extends ArrayAdapter {

    MediaPlayer mediaPlayer;
    //mLayoutId refers to the ListView item xml
    int mLayoutID;
    // The collection of Number objects sent as data
    ArrayList<Number> mNumbers;
    Context mContext;

    public ColorAdaptor(@NonNull Context context,
                        @LayoutRes int resource,
                        @NonNull ArrayList<Number> objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mNumbers = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }
        //Get the Number object for the current position
        Number currentNumber = mNumbers.get(position);

        //Set the attributed of list_view_number_item views
        ImageView iconImageView = (ImageView) currentListViewItem.findViewById(R.id.image_view_icon);


        //set English Text
        TextView EngTextView = (TextView) currentListViewItem.findViewById(R.id.text_view_English_word);
        EngTextView.setText(currentNumber.getEnglish());

        TextView maoriTextView = (TextView) currentListViewItem.findViewById(R.id.text_view_maori_word);
        maoriTextView.setText(currentNumber.getMaoriTranslation());

       // View cardview = (View) currentListViewItem.findViewById(R.id.image_view_card);
        TextView cardview = EngTextView;
        if (currentNumber.getEnglish().toLowerCase().equals("yellow")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.yellow));
        } else if (currentNumber.getEnglish().toLowerCase().equals("red")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.red));
        } else if (currentNumber.getEnglish().toLowerCase().equals("orange")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.orange));
        } else if (currentNumber.getEnglish().toLowerCase().equals("pink")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.pink));
        } else if (currentNumber.getEnglish().toLowerCase().equals("purple")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.purple));
        } else if (currentNumber.getEnglish().toLowerCase().equals("blue")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.blue));
        } else if (currentNumber.getEnglish().toLowerCase().equals("green")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.green));
        } else if (currentNumber.getEnglish().toLowerCase().equals("brown")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.brown));
        } else if (currentNumber.getEnglish().toLowerCase().equals("grey")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.grey));
        } else if (currentNumber.getEnglish().toLowerCase().equals("white")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.white));
            //EngTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.black));
            //maoriTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.black));
        } else if (currentNumber.getEnglish().toLowerCase().equals("black")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.black));
           // EngTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.white));
          //  maoriTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.white));
        }


       /* if (currentNumber.getEnglish().toLowerCase().equals("yellow")) {
            cardview.setTextColor(ContextCompat.getColor(this.mContext, R.color.yellow));
        } else if (currentNumber.getEnglish().toLowerCase().equals("red")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.red));
        } else if (currentNumber.getEnglish().toLowerCase().equals("orange")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.orange));
        } else if (currentNumber.getEnglish().toLowerCase().equals("pink")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.pink));
        } else if (currentNumber.getEnglish().toLowerCase().equals("purple")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.purple));
        } else if (currentNumber.getEnglish().toLowerCase().equals("blue")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.blue));
        } else if (currentNumber.getEnglish().toLowerCase().equals("green")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.green));
        } else if (currentNumber.getEnglish().toLowerCase().equals("brown")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.brown));
        } else if (currentNumber.getEnglish().toLowerCase().equals("grey")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.grey));
        } else if (currentNumber.getEnglish().toLowerCase().equals("white")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.white));
            EngTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.black));
            maoriTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.black));
        } else if (currentNumber.getEnglish().toLowerCase().equals("black")) {
            cardview.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.black));
            EngTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.white));
            maoriTextView.setTextColor(ContextCompat.getColor(this.mContext, R.color.white));
        }*/




        //Gettting the audio resource id for the current Number object
        final String audio = currentNumber.getAudio();
        final ImageView play = (ImageView) currentListViewItem.findViewById(R.id.image_view_play);

        //Setting the image click handler
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Operations to perform when the play ImageView is clicked
                int i = mContext.getResources().getIdentifier(
                        audio, "raw",
                        mContext.getPackageName());
                //Using MediaPlayer to play the audio file
                if (mediaPlayer != null)
                    mediaPlayer.release();
                // to avoid any error or crashes if no audio found
                //pratk parmar 16-Nov
                try {
                    mediaPlayer = MediaPlayer.create(mContext, i);
                    mediaPlayer.start();
                    Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
                    animation1.setDuration(800);
                    play.startAnimation(animation1);
                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }


            }
        });





        return currentListViewItem;
    }

}
