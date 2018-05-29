package app.secretcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class MainActivity extends AppCompatActivity {

    public static String secretKey_en; //암호화값
    public static String secretKey_de; //복호화값

    EditText editText;
    TextView textView1, textView2;
    Button button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AES256Chiper aes256Chiper = new AES256Chiper();

        button1= (Button)findViewById(R.id.button1);
        button2= (Button)findViewById(R.id.button2);

        editText = (EditText)findViewById(R.id.editText);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);

        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    secretKey_en = aes256Chiper.AES_Encode(editText.getText().toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                }


                textView1.setText(secretKey_en);

            }
        }) ;



        button2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    secretKey_de = aes256Chiper.AES_Decode(secretKey_en);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchPaddingException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                }


                textView2.setText(secretKey_de);

            }
        }) ;

    }
}
