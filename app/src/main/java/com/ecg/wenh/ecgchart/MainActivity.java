package com.ecg.wenh.ecgchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ecg.wenh.ecgchart.ecgview.ECG_allData_View;
import com.ecg.wenh.ecgchart.ecgview.StringToAscii;
import com.ecg.wenh.ecgchart.ecgview.WH_ECGView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WH_ECGView ecgView;
//    private ECG_allData_View allData_view;

    private ArrayList<String> data_source;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data_source = new ArrayList<>();
        changeData(ReadAssetsFileUtils.readAssetsTxt(this,"tttt"));
        ecgView = (WH_ECGView)findViewById(R.id.ecg_data_ecgView);
//        allData_view = (ECG_allData_View)findViewById(R.id.allData_ecgView);
        ecgView.setData(data_source);
//        allData_view.setData(data_source);

    }


    private void changeData(String starCareData) {
        try {
            Log.d(TAG, "changeData: "+starCareData);
           String[] strDatas = starCareData.split(",");
            for (int i = 0;i<strDatas.length;i++){
//            datas.add(Integer.valueOf(strDatas[i].replace("\r","")));
                String str = strDatas[i];
                Log.d(TAG, "changeData: str="+str);
                data_source.add(strDatas[i].replace("\r",""));
            }
            Log.d(TAG, "changeData: allDatas size is "+String.valueOf(data_source.size()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
