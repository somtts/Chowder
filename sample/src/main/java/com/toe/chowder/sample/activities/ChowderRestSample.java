package com.toe.chowder.sample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.toe.chowder.Chowder;
import com.toe.chowder.constructors.ChowderCredentials;
import com.toe.chowder.sample.R;

import static com.toe.chowder.Chowder.COMMAND_BUSINESS_BUY_GOODS;
import static com.toe.chowder.Chowder.COMMAND_BUSINESS_PAYMENT;

public class ChowderRestSample extends AppCompatActivity {

    //Test Credentials
    private String MPESA_KEY = "wqsTcAtuGr23sSw8bGJ2wiH2kuKsoiRb";
    private String MPESA_SECRET = "agIRcwcVIGHd6ozD";
    private String INITIATOR_PASSWORD = "ch0wder123@";

    private String SHORT_CODE_1 = "603049";
    private String INITIATOR_NAME_SHORT_CODE_1 = "safaricom.12";
    private String SECURITY_CREDENTIAL_SHORT_CODE_1 = "9078";
    private String SHORT_CODE_2 = "600000";
    private String MSISDN = "254708374149";
    private String EXPIRY_DATE = "2017-09-18T13:54:17+03:00";
    private String LIPA_NA_MPESA_SHORTCODE = "174379";
    private String LIPA_NA_MPESA_PASSKEY = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
    private String GENERATED_INITIATOR_SECURITY_CREDENTIAL = "CkX5JQ47fwVODup1d4NEw8J1TDkNDwIDiL7R2JitdIX+06cTTbGroHZkETZCFP7gTEMrstfRuXJYR+pmtPqto0KVO0TOiZ4UkVM0DtqXQihAtUL8tL9Shpl9lTv6nFR2FAMPF/Brx1WQh4CfMNwOS4WZHgPwJpTu6Ah//pW+7FelkZlaQeXwqD7VlJS0yuYNg3t5BWx0hSe7gCvg7q6rL/gmH47LUZMK7Ti+w5jPinMNPPsibpa+i9AcA3WXhuiOze2scOBfKFii8PlezWtlpCX0TX3tysfp+9nytAz72BToEaq7SW6Nfk/jQ1j5IIoThaYNUq5PiSMdzxHk7jDDsw==";

    //Views
    private Button bB2c, bB2b, bC2b;

    //Chowder
    private ChowderCredentials chowderCredentials;
    private Chowder chowder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chowder_rest_sample);

        setUp();
    }

    private void setUp() {
        chowderCredentials = new ChowderCredentials(MPESA_KEY, MPESA_SECRET, INITIATOR_PASSWORD, SHORT_CODE_1, INITIATOR_NAME_SHORT_CODE_1, SECURITY_CREDENTIAL_SHORT_CODE_1, SHORT_CODE_2, MSISDN, EXPIRY_DATE, LIPA_NA_MPESA_SHORTCODE, LIPA_NA_MPESA_PASSKEY, GENERATED_INITIATOR_SECURITY_CREDENTIAL);
        chowder = new Chowder(this, chowderCredentials);
        chowder.generateAccessToken();

        bB2c = (Button) findViewById(R.id.bB2c);
        bB2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chowder.b2cPaymentRequest(COMMAND_BUSINESS_PAYMENT, 1000);
            }
        });

        bB2b = (Button) findViewById(R.id.bB2b);
        bB2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chowder.b2bPaymentRequest(COMMAND_BUSINESS_BUY_GOODS, 1000);
            }
        });

        bC2b = (Button) findViewById(R.id.bC2b);
        bC2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chowder.c2bPaymentRequest(COMMAND_BUSINESS_PAYMENT, 1000);
            }
        });
    }
}