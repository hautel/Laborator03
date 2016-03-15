package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class PhoneDialerActivity extends Activity {

	static int buttonIds[] = {R.id.button1, R.id.button2, R.id.button3,R.id.button4, R.id.button5,
		R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        for(int i =1; i<=12;i++){
        	final Button btn = (Button)findViewById(buttonIds[i-1]);
        	Log.d("", "hello" + i);
        	if(btn == null) continue;
        	Log.d("", "hello after" + i);
        	btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					String text = btn.getText().toString();
					
					EditText edtxt = (EditText)findViewById(R.id.editText);
					String edtxtContent = edtxt.getText().toString();
					edtxtContent = edtxtContent + text;
					Log.d("", edtxtContent);
					edtxt.setText(edtxtContent);
				}
			});
        	
        }
        
        ImageButton bckBtn = (ImageButton)findViewById(R.id.imageButton1);
        if (bckBtn != null){
	        bckBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.d("", "hello");
					EditText edtxt = (EditText)findViewById(R.id.editText);
					String edtxtContent = edtxt.getText().toString();
					if(edtxtContent.length()>0){
					edtxtContent = edtxtContent.substring(0,edtxtContent.length()-1);
					}
					edtxt.setText(edtxtContent);
					
				}
			});
        }
        
        ImageButton callBtn = (ImageButton)findViewById(R.id.imageButton2);
        if(callBtn!=null){
        	callBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					EditText edtxt = (EditText)findViewById(R.id.editText);
					String edtxtContent = edtxt.getText().toString();
					
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+edtxtContent));
					startActivity(intent);
				}
			});
        	
        }
        
        ImageButton closeBtn = (ImageButton)findViewById(R.id.imageButton3);
        if(closeBtn!=null){
        	closeBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
        }
        
        ImageButton addContact = (ImageButton)findViewById(R.id.imageButton4);
        if(addContact!=null){
        	addContact.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					EditText edtxt = (EditText)findViewById(R.id.editText);
					String phoneNumber = edtxt.getText().toString();
					if(phoneNumber.length()>0){
						Intent intent = new Intent("ro.pub.cs.systems.pdsd.lab04.contactsmanager.intent.action.ContactsManagerActivity");
						intent.putExtra("ro.pub.cs.systems.pdsd.lab04.contactsmanager.PHONE_NUMBER_KEY", phoneNumber);
						startActivityForResult(intent, 13);
					
					}else{
						Toast.makeText(getApplication(), getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
					}
					
				}
			});
        	
        }
    
    
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
