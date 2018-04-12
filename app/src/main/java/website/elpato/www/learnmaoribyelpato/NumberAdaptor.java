package website.elpato.www.learnmaoribyelpato;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Dell on 11/13/2017.
 */
/*
public class NumberAdaptor extends ArrayAdapter {
    public NumberAdaptor(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}*/
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class NumberAdaptor extends ArrayAdapter {

    MediaPlayer mediaPlayer;
    //mLayoutId refers to the ListView item xml
    int mLayoutID;
    // The collection of Number objects sent as data
    ArrayList<Number> mNumbers;
    Context mContext;

    public NumberAdaptor(@NonNull Context context,
                         @LayoutRes int resource,
                         @NonNull ArrayList<Number> objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mNumbers = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
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


        int i = mContext.getResources().getIdentifier(
                currentNumber.getIcon(), "drawable",
                mContext.getPackageName());

        try{
            //Setting the icon
            iconImageView.setImageResource(i);
        }catch (Exception e)
        {

        }

        //set English Text
        TextView EngTextView = (TextView) currentListViewItem.findViewById(R.id.text_view_English_word);
        EngTextView.setText(currentNumber.getEnglish());

        TextView maoriTextView = (TextView) currentListViewItem.findViewById(R.id.text_view_maori_word);
        maoriTextView.setText(currentNumber.getMaoriTranslation());

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
                // to avoid any error or crashes if no audio found
                //pratk parmar 16-Nov
                if (mediaPlayer != null)
                {
                    mediaPlayer.release();
                }
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
