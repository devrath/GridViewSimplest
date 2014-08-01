package com.example.grid;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.example.GridViewBasic.R;

public class MainActivity extends Activity {

	GridView grid;
	
	LinkedList<LinkedHashMap<String, String>> messengerListObject;
	LinkedHashMap<String, String> messengerMapObject;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		grid=(GridView) findViewById(R.id.grid);
		
		addDataForCollection();
		
		messengerListObject.add(messengerMapObject);
		CustomGrid adapter = new CustomGrid(MainActivity.this,messengerListObject);
		grid.setAdapter(adapter);
		
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Toast.makeText(MainActivity.this, "You Clicked at " +messengerListObject.get(position).get("android"), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void addDataForCollection() {
		messengerListObject=new LinkedList<LinkedHashMap<String, String>>();
		for(int i=1;i<30;i++){
			messengerMapObject=new LinkedHashMap<String, String>();
			messengerMapObject.put("android", "Android-"+i+"");
			messengerListObject.add(messengerMapObject);
		}
	}
}

