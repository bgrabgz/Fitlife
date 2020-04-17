package com.example.deneme1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<String> mArrayList;
    private Context mContext;
    public ListAdapter(Activity activity,Context context, ArrayList<String> arrayList){
        this.mActivity = activity;
        this.mContext = context;
        this.mArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(inflater == null) return null;
            convertView = inflater.inflate(R.layout.list_menu,parent,false);
        }
        Log.d(ListAdapter.class.getName(), "getView: " +mArrayList.get(position));
        TextView textView = convertView.findViewById(R.id.listTextView);

        textView.setText(mArrayList.get(position));

        return convertView;
    }
}
