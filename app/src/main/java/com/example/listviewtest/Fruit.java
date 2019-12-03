package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Fruit {
    private String name;
    private int imagedId;
    public Fruit(String name,int imagedId)
    {
        this.name =name;
        this.imagedId =imagedId;
    }
    public String getName(){return name;}
    public int getImagedId(){return imagedId;}
}



