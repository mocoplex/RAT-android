package test.rat.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.mocoplex.rat.Picky;
import com.mocoplex.rat.PickyListener;
import com.mocoplex.rat.PickyProduct;

public class PickyNativeActivity extends AppCompatActivity {
	
	private static String PICKY_CHANNEL_ID = "채널 아이디를 입력하세요.";

	private Picky picky;
	private EditText edittext;
	private EditText editItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picky_native);
		
		Button btn = (Button)findViewById(R.id.view);
		edittext = (EditText)findViewById(R.id.edittext);
		editItem = (EditText)findViewById(R.id.edit_item);
		
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {

				picky = new Picky(PickyNativeActivity.this, PICKY_CHANNEL_ID);
				picky.recomProdByProd(Picky.Tag.BUY, "145527", 5, new PickyListener() {

					@Override
					public void onReceive(String json) {
						edittext.setText(json);
						test_display();
					}

					@Override
					public void onFailedToReceive() {
						
					}
					
				});
			}			
		});

	}
	
	public void clickButton(View v) {
		test_click();
	}
	
	private void test_display() {
		if(picky == null)
			return;
		
		int size = picky.recomListSize();
		if(size > 0) {
			PickyProduct item = picky.displayProduct(0);
			String pNo = item.getProduct_no();
			String pName = item.getProduct_name();
			String thumb = item.getThumbUrl();
//			String price = item.getPrice();
//			String regularPrice = item.getRegular_price();
//			String discountPrice = item.getDiscount_price();
//			String category1 = item.getCategory_name1();
//			String category2 = item.getCategory_name2();
//			String category3 = item.getCategory_name3();
//			String shopId = item.getShop_id();
//			String date = item.getDate();
			editItem.setText(pName);
		}
	}
	
	private void test_click() {
		if(picky == null)
			return;
		
		int size = picky.recomListSize();
		if(size > 0) {
			PickyProduct item = picky.clickProduct(0);
		}
	}
}
