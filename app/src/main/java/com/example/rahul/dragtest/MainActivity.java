package com.example.rahul.dragtest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    LayoutInflater mInflater;

    ArrayList<Integer> mResourceStructure;
    DynamicGridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = getLayoutInflater();

        mResourceStructure = new ArrayList<Integer>();

        mResourceStructure.add(R.drawable.beach);
        mResourceStructure.add(R.drawable.bugatti);
        mResourceStructure.add(R.drawable.mountain);
        mResourceStructure.add(R.drawable.sun);


        mGridView = (DynamicGridView)findViewById(R.id.grid_view);
        ImageAdapter imageApdater =  new ImageAdapter(this,mResourceStructure,2);
        mGridView.setAdapter(imageApdater);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class ImageAdapter extends BaseDynamicGridAdapter{

        MainActivity activity;
        public ImageAdapter(Context context, List<?> items, int columnCount) {
            super(context, items, columnCount);
            activity = (MainActivity)context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if(convertView == null){

                viewHolder  = new ViewHolder();
                convertView = mInflater.inflate(R.layout.grid_element,null);

                viewHolder.imageView = (ImageView)convertView.findViewById(R.id.image_view);
                convertView.setTag(viewHolder);

            }
            else{

                viewHolder = (ViewHolder)convertView.getTag();
            }

            Drawable drawable = activity.getDrawable(mResourceStructure.get(position));
            viewHolder.imageView.setImageDrawable(drawable);

            return convertView;
        }
    }

    public static class ViewHolder{

        static ImageView imageView;

    }
}
