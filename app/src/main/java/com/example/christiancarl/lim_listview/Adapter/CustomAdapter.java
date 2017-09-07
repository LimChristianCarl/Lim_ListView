package com.example.christiancarl.lim_listview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.christiancarl.lim_listview.Activity.MainActivity;
import com.example.christiancarl.lim_listview.Model.College;
import com.example.christiancarl.lim_listview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Carl on 07/09/2017.
 */

public class CustomAdapter extends BaseAdapter{

    private List<College> colleges;
    Context myContext;
    ImageView image;
    TextView college_Name;
    TextView college_Year;

    @Override
    public int getCount() {
        return colleges.size();
    }

    @Override
    public Object getItem(int i) {
        return colleges.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public CustomAdapter(Context myContext, List<College> colleges){
        this.myContext = myContext;
        this.colleges = colleges;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(myContext, R.layout.new_layout, null);
        image = (ImageView) v.findViewById(R.id.logo);
        college_Name = (TextView) v.findViewById(R.id.College);
        college_Year = (TextView) v.findViewById(R.id.Year);

        college_Name.setText(colleges.get(i).getCollege());
        college_Year.setText(colleges.get(i).getYear());
        image.setImageResource(colleges.get(i).getLogo());

        return v;
    }
}
