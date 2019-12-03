package com.example.listviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>
{
    String TAG="FruitAdapter";
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects)//构造函数
    {
        super(context,textViewResourceId,objects);
        resourceId =textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit =getItem(position);//获取当前项的Fruit 实例
        View view;
        ViewHolder viewHolder;
        if(convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder =new ViewHolder();
            viewHolder.fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName =(TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder); //将ViewHolder 存储在View 中
            Log.d(TAG,viewHolder.fruitName.toString()+"存储");
        }
        else {
            view=convertView;
            viewHolder =(ViewHolder) view.getTag(); //重新获取ViewHolder
            Log.d(TAG,viewHolder.fruitName.toString()+"获取");
        }
        viewHolder.fruitImage.setImageResource(fruit.getImagedId());
        viewHolder.fruitName.setText(fruit.getName());
//        ImageView fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName =(TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImagedId());
//        fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
