package test.rat.sample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mocoplex.rat.Tracker;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 트래킹 연동을 위해 필수로 첫페이지에서 호출되어야 합니다. (초기화)
		Tracker.getInstance().init(this);
		
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("Native");
		itemList.add("Picky Native");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
		
		this.setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Intent intent = null;
		switch (position) {
	
			case 0: // native
				intent = new Intent(MainActivity.this, NativeActivity.class);
				startActivity(intent);
				break;
				
			case 1: // picky native
				intent = new Intent(MainActivity.this, PickyNativeActivity.class);
				startActivity(intent);
				break;
		}
	}
}
