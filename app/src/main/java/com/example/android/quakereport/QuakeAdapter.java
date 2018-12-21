package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeAdapter extends ArrayAdapter<Quake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public QuakeAdapter(Activity context, ArrayList<Quake> list){
        super(context,0,list);
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
           listItemView =LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Quake currentItem = getItem(position);

        DecimalFormat format = new DecimalFormat("0.0");
        String magnitude = format.format(currentItem.getLevel());



        TextView levelTextView = (TextView)listItemView.findViewById(R.id.level_text_view);

        GradientDrawable magnitudeCircle = (GradientDrawable) levelTextView.getBackground();

        int magnitudeColor = getMagnatudeColor(currentItem.getLevel());

        magnitudeCircle.setColor(magnitudeColor);

        levelTextView.setText(magnitude);


        String originalLocation = currentItem.getLocation();

        String primaryLocation;
        String locationOffset;

        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String []parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }

        else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }


        TextView locationTextView = (TextView)listItemView.findViewById(R.id.location_text_view);
        locationTextView.setText(primaryLocation);

        TextView locationOffsetTextView = (TextView)listItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(locationOffset);


        Date date = new Date(currentItem.getDate());

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date_text_view);
        String formatDate = formatDate(date);
        dateTextView.setText(formatDate);


        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time_text_view);
        String formatTime = timeFormat(date);
        timeTextView.setText(formatTime);

        return listItemView;
    }


    private int getMagnatudeColor(double magnitudeLevel){
        int color;
        int magnitudeLevelInt = (int)Math.floor(magnitudeLevel);

        switch (magnitudeLevelInt){
            case 0:

            case 1:
                color = R.color.magnitude1;
                break;
            case 2:
                color = R.color.magnitude2;
                break;
            case 3:
                color = R.color.magnitude3;
                break;
            case 4:
                color = R.color.magnitude4;
                break;
            case 5:
                color = R.color.magnitude5;
                break;
            case 6:
                color = R.color.magnitude6;
                break;
            case 7:
                color = R.color.magnitude7;
                break;
            case 8:
                color = R.color.magnitude8;
                break;
            case 9:
                color = R.color.magnitude9;
                break;
            case 10:
                color = R.color.magnitude10plus;
                break;

                default:
                    color = R.color.magnitude10plus;
                    break;


        }

        return ContextCompat.getColor(getContext(),color);
    }

    private String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(date);
    }

    private  String timeFormat(Date date){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(date);
    }
}
