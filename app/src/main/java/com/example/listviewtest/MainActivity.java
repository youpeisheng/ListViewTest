package com.example.listviewtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList =new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView =(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()  //注册一个回调函数 当AdapterView 某一项被点击时会被调用
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits()
    {
        for(int i=0;i<200;i++)
        {
            Fruit apple =new Fruit("Apple",R.mipmap.ic_launcher);
            fruitList.add(apple);
        }
    }

}

//    private String[] data={"Apple","Banana","Orange","watermelon","Pear","Grape","Pineapple",
//            "Strawberry","Cherry","Mango","Apple","Banana","Orange","watermelon","Pear","Grape","Pineapple",
//            "Strawberry","Cherry","Mango"};
//ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initFruits(); //初始化水果数据
//        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
//        ListView listView=(ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//    }