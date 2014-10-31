package net.cozz.danco.homework3;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by costd035 on 10/30/14.
 */
public class TextViewAdapter extends BaseAdapter {
    private final static String TAG = TextViewAdapter.class.getCanonicalName();

    private final Context context;

    private final List<String> states;

    // Constructor
    public TextViewAdapter(Context context){
        this.context = context;
        states = Arrays.asList(context.getResources().getStringArray(R.array.states));
    }

    public List<String> getStates() {
        return states;
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public Object getItem(int i) {
        return states.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Random r = new Random(position);
        TextView textView = new TextView(context);
        textView.setText(states.get(position));
        int randColor = r.nextInt();
        textView.setTextColor(randColor / 2);
        textView.setBackgroundColor(randColor);
        textView.setTextSize(dp2Px(14));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        textView.setHeight(dp2Px(38));

        return textView;
    }


    public int dp2Px(int dp){
        Log.i(TAG, "dp2Px");

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    static class ViewHolder {
        public TextView stateName;
        public View leftBox;
        public View rightBox;
    }

}
