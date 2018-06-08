package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudEarthquake = (TextView) listItemView.findViewById(R.id.magnitud);
        magnitudEarthquake.setText(currentEarthquake.getmMagnitud()+"");

        TextView offsetView = (TextView) listItemView.findViewById(R.id.offset);
        offsetView.setText(currentEarthquake.getmOffset());

        TextView primaryView = (TextView) listItemView.findViewById(R.id.primary);
        primaryView.setText(currentEarthquake.getmPrimaryLocation());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getmDate());

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(currentEarthquake.getmDate());

        ///seting the background to the magnitud circle
        GradientDrawable magnitudCircle = (GradientDrawable) magnitudEarthquake.getBackground();
        int magnitudColor = getMagnitudeColor(currentEarthquake.getmMagnitud());

        magnitudCircle.setColor(magnitudColor);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitud){

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitud);

        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
