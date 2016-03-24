package test.rat.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mocoplex.rat.Tracker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// 트래킹 연동을 위해 필수로 첫페이지에서 호출되어야 합니다. (초기화)
		Tracker.getInstance().init(this);
		
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("Native");
		itemList.add("Picky Native");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);

		listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
