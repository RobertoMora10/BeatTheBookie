package edu.fsu.cs.mobile.beatthebookie;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Bet> {

    private Context mContext;
    private ArrayList<Bet> mBets;



    public CustomAdapter(@NonNull Context context, int resource)
    {
        super(context, resource);
        mContext=context;
        mBets= new ArrayList<>();
    }

    private static class MyBetHolder {
        TextView textViewEntry;
        TextView textViewScore;
        ImageButton upButton;
        ImageButton downButton;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Bet item = getItem(position);
        MyBetHolder viewHolder;
        if (convertView == null) {
            // If row has not been created, inflate from row_object.xml
            //   and assign viewHolder to tag
            viewHolder = new MyBetHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.textViewEntry =(TextView) convertView.findViewById(R.id.entry);
            viewHolder.textViewScore=(TextView) convertView.findViewById(R.id.Score);
            viewHolder.upButton=(ImageButton) convertView.findViewById(R.id.upButton);
            viewHolder.downButton=(ImageButton) convertView.findViewById(R.id.downButton);
            convertView.setTag(viewHolder);
        }
        else {
            // If row has been created, get viewHolder from tag
            viewHolder = (MyBetHolder) convertView.getTag();
        }

        viewHolder.textViewEntry.setText(item.getText());
        viewHolder.textViewScore.setText(String.valueOf( item.getVotes()));
        //still have to set the buttons

        return convertView;

    }

    @Override
    public int getCount() {
        return mBets.size();
    }


    @Nullable
    @Override
    public Bet getItem(int position) {
        return mBets.get(position);
    }

    @Override
    public int getPosition(@Nullable Bet item) {
        // Find if item is already in mObjects by checking text
        for (int i = 0; i < mBets.size(); i++) {
            if (TextUtils.equals(item.getText(), mBets.get(i).getText())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(@Nullable Bet object) {
        int idx = getPosition(object);
        if (idx >= 0) {
            mBets.set(idx, object);
        } else {
            mBets.add(object);
        }
        notifyDataSetChanged();
    }

}