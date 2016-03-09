package test.rat.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mocoplex.rat.Tracker;

import org.json.JSONException;
import org.json.JSONObject;

public class NativeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.native_main);
		
		Button btn;
		
		// view
		btn = (Button)this.findViewById(R.id.view);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				try {
					JSONObject obj = new JSONObject();
					obj.put("p_no", "상품번호1");				// 상품 번호
					obj.put("p_name", "상품 이름 입력");		// 상품 이름
					
					obj.put("price", "12300"); 				// 상품 현재 판매가 (할인 시 할인가, 미할인 시 원가) : 숫자만
					obj.put("shop_id", "xxx mall"); 		// 샵 아이디
					obj.put("thumb", "http://상품이미지주소");	// 썸네일 주소 ( http:// https:// 포함 전체 url)
					
					obj.put("cate1", "카테고리 정보 1, 대분류");	//카테고리 대분류 (상품카테고리 대분류 : 없을 시 빈 값)
					obj.put("cate2", "카테고리 정보 2, 중분류");	//카테고리 중분류 (상품카테고리 중분류 : 없을 시 빈 값)
					obj.put("cate3", "카테고리 정보 3, 소분류");	//카테고리 소분류 (상품카테고리 소분류 : 없을 시 빈 값)
					
					obj.put("regular_price", "12300"); 		// 정상 가격 (정상가 미할인 가격 : 없을 시 빈 값) : 숫자만
					obj.put("discount", ""); 				// 세일 가격 (없을 시 빈값) : 숫자만
					
					// 기타 부가 정보
					obj.put("account", "");					// 로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백
					obj.put("qty", "상품 수량");
					obj.put("platform", "mobile_app");
						
					Tracker.getInstance().viewTag(NativeActivity.this, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}			
		});

		// cart
		btn = (Button)this.findViewById(R.id.cart);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				// 여러 상품의 경우 아래와 같이 반복해서 호출해주세요.
				try {
					JSONObject obj = new JSONObject();
					obj.put("p_no", "상품번호1");				// 상품 번호
					obj.put("p_name", "상품 이름 입력");		// 상품 이름
					
					obj.put("price", "12300"); 				// 상품 현재 판매가 (할인 시 할인가, 미할인 시 원가) : 숫자만
					obj.put("shop_id", "xxx mall"); 		// 샵 아이디
					obj.put("thumb", "http://상품이미지주소");	// 썸네일 주소 ( http:// https:// 포함 전체 url)
					
					obj.put("cate1", "카테고리 정보 1, 대분류");	//카테고리 대분류 (상품카테고리 대분류 : 없을 시 빈 값)
					obj.put("cate2", "카테고리 정보 2, 중분류");	//카테고리 중분류 (상품카테고리 중분류 : 없을 시 빈 값)
					obj.put("cate3", "카테고리 정보 3, 소분류");	//카테고리 소분류 (상품카테고리 소분류 : 없을 시 빈 값)
					
					obj.put("regular_price", "12300"); 		// 정상 가격 (정상가 미할인 가격 : 없을 시 빈 값) : 숫자만
					obj.put("discount", ""); 				// 세일 가격 (없을 시 빈값) : 숫자만
					
					// 기타 부가 정보
					obj.put("account", "");					// 로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백
					obj.put("qty", "상품 수량");
					obj.put("platform", "mobile_app");
						
					Tracker.getInstance().cartTag(NativeActivity.this, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

				
				try {
					JSONObject obj = new JSONObject();
					obj.put("p_no", "상품번호2");				// 상품 번호
					obj.put("p_name", "상품 이름 입력");		// 상품 이름
					
					obj.put("price", "12300"); 				// 상품 현재 판매가 (할인 시 할인가, 미할인 시 원가) : 숫자만
					obj.put("shop_id", "xxx mall"); 		// 샵 아이디
					obj.put("thumb", "http://상품이미지주소");	// 썸네일 주소 ( http:// https:// 포함 전체 url)
					
					obj.put("cate1", "카테고리 정보 1, 대분류");	//카테고리 대분류 (상품카테고리 대분류 : 없을 시 빈 값)
					obj.put("cate2", "카테고리 정보 2, 중분류");	//카테고리 중분류 (상품카테고리 중분류 : 없을 시 빈 값)
					obj.put("cate3", "카테고리 정보 3, 소분류");	//카테고리 소분류 (상품카테고리 소분류 : 없을 시 빈 값)
					
					obj.put("regular_price", "12300"); 		// 정상 가격 (정상가 미할인 가격 : 없을 시 빈 값) : 숫자만
					obj.put("discount", ""); 				// 세일 가격 (없을 시 빈값) : 숫자만
					
					// 기타 부가 정보
					obj.put("account", "");					// 로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백
					obj.put("qty", "상품 수량");
					obj.put("platform", "mobile_app");
					
					Tracker.getInstance().cartTag(NativeActivity.this, obj);
				
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}			
		});
		
		// buy
		btn = (Button)this.findViewById(R.id.buy);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {

				// 여러 상품의 경우 아래와 같이 반복해서 호출해주세요.
				try {
					JSONObject obj = new JSONObject();
					obj.put("p_no", "상품번호1");				// 상품 번호
					obj.put("p_name", "상품 이름 입력");		// 상품 이름
					
					obj.put("price", "12300"); 				// 상품 현재 판매가 (할인 시 할인가, 미할인 시 원가) : 숫자만
					obj.put("shop_id", "xxx mall"); 		// 샵 아이디
					obj.put("thumb", "http://상품이미지주소");	// 썸네일 주소 ( http:// https:// 포함 전체 url)
					
					obj.put("cate1", "카테고리 정보 1, 대분류");	//카테고리 대분류 (상품카테고리 대분류 : 없을 시 빈 값)
					obj.put("cate2", "카테고리 정보 2, 중분류");	//카테고리 중분류 (상품카테고리 중분류 : 없을 시 빈 값)
					obj.put("cate3", "카테고리 정보 3, 소분류");	//카테고리 소분류 (상품카테고리 소분류 : 없을 시 빈 값)
					
					obj.put("regular_price", "12300"); 		// 정상 가격 (정상가 미할인 가격 : 없을 시 빈 값) : 숫자만
					obj.put("discount", ""); 				// 세일 가격 (없을 시 빈값) : 숫자만
					
					// 기타 부가 정보
					obj.put("account", "");					// 로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백
					obj.put("qty", "상품 수량");
					obj.put("platform", "mobile_app");
						
					Tracker.getInstance().buyTag(NativeActivity.this, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}

				
				try {
					JSONObject obj = new JSONObject();
					obj.put("p_no", "상품번호2");				// 상품 번호
					obj.put("p_name", "상품 이름 입력");		// 상품 이름
					
					obj.put("price", "12300"); 				// 상품 현재 판매가 (할인 시 할인가, 미할인 시 원가) : 숫자만
					obj.put("shop_id", "xxx mall"); 		// 샵 아이디
					obj.put("thumb", "http://상품이미지주소");	// 썸네일 주소 ( http:// https:// 포함 전체 url)
					
					obj.put("cate1", "카테고리 정보 1, 대분류");	//카테고리 대분류 (상품카테고리 대분류 : 없을 시 빈 값)
					obj.put("cate2", "카테고리 정보 2, 중분류");	//카테고리 중분류 (상품카테고리 중분류 : 없을 시 빈 값)
					obj.put("cate3", "카테고리 정보 3, 소분류");	//카테고리 소분류 (상품카테고리 소분류 : 없을 시 빈 값)
					
					obj.put("regular_price", "12300"); 		// 정상 가격 (정상가 미할인 가격 : 없을 시 빈 값) : 숫자만
					obj.put("discount", ""); 				// 세일 가격 (없을 시 빈값) : 숫자만
					
					// 기타 부가 정보
					obj.put("account", "");					// 로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백
					obj.put("qty", "상품 수량");
					obj.put("platform", "mobile_app");
					
					Tracker.getInstance().buyTag(NativeActivity.this, obj);
				
				} catch (JSONException e) {
					e.printStackTrace();
				}				
				
			}
		});
		
		// custom
		// 그 외에 수집하고 싶은 이벤트가 있다면 custom 태그를 사용하실 수 있습니다. 수집할 항목들은 자유롭게 하셔도 됩니다.
		/*
		btn = (Button)this.findViewById(R.id.custom);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
			
				try {
					String event = "LIKE";					// 커스텀 태그명
					
					JSONObject obj = new JSONObject();
					obj.put("p_no", "상품번호1");				// 상품 번호
					obj.put("p_name", "상품 이름 입력");		// 상품 이름
					
					obj.put("price", "12300"); 				// 상품 현재 판매가 (할인 시 할인가, 미할인 시 원가) : 숫자만
					obj.put("shop_id", "xxx mall"); 		// 샵 아이디
					obj.put("thumb", "http://상품이미지주소");	// 썸네일 주소 ( http:// https:// 포함 전체 url)
					
					obj.put("cate1", "카테고리 정보 1, 대분류");	//카테고리 대분류 (상품카테고리 대분류 : 없을 시 빈 값)
					obj.put("cate2", "카테고리 정보 2, 중분류");	//카테고리 중분류 (상품카테고리 중분류 : 없을 시 빈 값)
					obj.put("cate3", "카테고리 정보 3, 소분류");	//카테고리 소분류 (상품카테고리 소분류 : 없을 시 빈 값)
					
					obj.put("regular_price", "12300"); 		// 정상 가격 (정상가 미할인 가격 : 없을 시 빈 값) : 숫자만
					obj.put("discount", ""); 				// 세일 가격 (없을 시 빈값) : 숫자만
					
					// 기타 부가 정보
					obj.put("account", "");					// 로그인 한 경우 사용자의 아이디 또는 이메일주소, 로그인하지 않은 경우 공백
					obj.put("qty", "상품 수량");
					obj.put("platform", "mobile_app");
						
					Tracker.getInstance().customTag(NativeActivity.this, event, obj);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}		
				
			}
		});
		*/
		
	}

}
