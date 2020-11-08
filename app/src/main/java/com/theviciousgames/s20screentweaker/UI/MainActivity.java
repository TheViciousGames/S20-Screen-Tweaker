package com.theviciousgames.s20screentweaker.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.theviciousgames.s20screentweaker.R;
import com.theviciousgames.s20screentweaker.backend.Display;
import com.theviciousgames.s20screentweaker.backend.Resources;
import com.theviciousgames.s20screentweaker.backend.Tools;

public class MainActivity extends AppCompatActivity {
    private Spinner hzSpinnerHD, hzSpinnerFHD, hzSpinnerWQHD, resSpinner;
    private String resValueToDo, rateValueToDo;
    private Button applyButton, helpButton;
    private ArrayAdapter<String> hzHDArrayAdapter, hzFHDArrayAdapter, hzWQHDArrayAdapter, resArrayAdapter;
    private String tempString;
    private TextView resolutionTextView, refreshRateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareVars();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initializeInformation();

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScreenSettings(resValueToDo, rateValueToDo);
                refreshTextView();
                Tools.Utils.vibration(MainActivity.this);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Choose the resolution and the refresh rate you want and press 'Apply'.\nEvery resolution has different refresh rate values available (Hardware limit).\nThis only works on S20.").setPositiveButton("Yes", dialogClickListener).show();
            }
        });

        hzSpinnerHD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_60;
                        break;
                    case 1:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_96;
                        break;
                    case 2:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_120;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        hzSpinnerFHD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_60;
                        break;
                    case 1:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_96;
                        break;
                    case 2:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_120;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        hzSpinnerWQHD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_48;
                        break;
                    case 1:
                        rateValueToDo = Resources.SCREEN_HZ_VALUE_60;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        hzSpinnerHD.setVisibility(View.VISIBLE);
                        hzSpinnerFHD.setVisibility(View.GONE);
                        hzSpinnerWQHD.setVisibility(View.GONE);

                        resValueToDo = Resources.SCREEN_RESOLUTION_VALUE_HD;
                        break;
                    case 1:
                        hzSpinnerHD.setVisibility(View.GONE);
                        hzSpinnerFHD.setVisibility(View.VISIBLE);
                        hzSpinnerWQHD.setVisibility(View.GONE);

                        resValueToDo = Resources.SCREEN_RESOLUTION_VALUE_FHD;
                        break;
                    case 2:
                        hzSpinnerHD.setVisibility(View.GONE);
                        hzSpinnerFHD.setVisibility(View.GONE);
                        hzSpinnerWQHD.setVisibility(View.VISIBLE);

                        resValueToDo = Resources.SCREEN_RESOLUTION_VALUE_WQHD;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    protected void declareVars() {

        hzSpinnerHD = findViewById(R.id.hzSpinnerHD);
        hzSpinnerFHD = findViewById(R.id.hzSpinnerFHD);
        hzSpinnerWQHD = findViewById(R.id.hzSpinnerWQHD);
        resSpinner = findViewById(R.id.resSpinner);
        applyButton = findViewById(R.id.applyButton);
        helpButton = findViewById(R.id.helpButton);

        resolutionTextView = findViewById(R.id.resolutionTextView);
        refreshRateTextView = findViewById(R.id.refreshRateTextView);

        hzHDArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.txt, getResources().getStringArray(R.array.refreshRatesHD));
        hzFHDArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.txt, getResources().getStringArray(R.array.refreshRatesFHD));
        hzWQHDArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.txt, getResources().getStringArray(R.array.refreshRatesWQHD));
        resArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.txt, getResources().getStringArray(R.array.resolutionValues));

        hzSpinnerHD.setAdapter(hzHDArrayAdapter);
        hzSpinnerFHD.setAdapter(hzFHDArrayAdapter);
        hzSpinnerWQHD.setAdapter(hzWQHDArrayAdapter);
        resSpinner.setAdapter(resArrayAdapter);

        hzSpinnerHD.setSelection(2);
        hzSpinnerFHD.setSelection(2);
        hzSpinnerWQHD.setSelection(1);
        resSpinner.setSelection(0);
    }

    protected void changeScreenSettings(final String resVal, final String rateVal) {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (resVal == Resources.SCREEN_RESOLUTION_VALUE_HD && rateVal == Resources.SCREEN_HZ_VALUE_48) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_HD, Resources.SCREEN_HZ_VALUE_48);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_HD && rateVal == Resources.SCREEN_HZ_VALUE_60) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_HD, Resources.SCREEN_HZ_VALUE_60);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_HD && rateVal == Resources.SCREEN_HZ_VALUE_96) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_HD, Resources.SCREEN_HZ_VALUE_96);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_HD && rateVal == Resources.SCREEN_HZ_VALUE_120) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_HD, Resources.SCREEN_HZ_VALUE_120);
                }
                ///FHD
                else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_FHD && rateVal == Resources.SCREEN_HZ_VALUE_48) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_FHD, Resources.SCREEN_HZ_VALUE_48);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_FHD && rateVal == Resources.SCREEN_HZ_VALUE_60) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_FHD, Resources.SCREEN_HZ_VALUE_60);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_FHD && rateVal == Resources.SCREEN_HZ_VALUE_96) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_FHD, Resources.SCREEN_HZ_VALUE_96);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_FHD && rateVal == Resources.SCREEN_HZ_VALUE_120) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_FHD, Resources.SCREEN_HZ_VALUE_120);
                }
                ///WQHD
                else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_WQHD && rateVal == Resources.SCREEN_HZ_VALUE_48) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_WQHD, Resources.SCREEN_HZ_VALUE_48);
                } else if (resVal == Resources.SCREEN_RESOLUTION_VALUE_WQHD && rateVal == Resources.SCREEN_HZ_VALUE_60) {
                    Tools.Utils.changeResAndRateTo(Resources.SCREEN_RESOLUTION_VALUE_WQHD, Resources.SCREEN_HZ_VALUE_60);
                }
            }
        });
        backgroundThread.start();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("hi")
                .setPositiveButton("hi", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    protected void initializeInformation() {
        refreshTextView();

        if (Display.Resolution.getCurrentVerticalPixels(MainActivity.this) == 1461) {
            tempString = "Resolution HD";
            resolutionTextView.setText(tempString);
        } else if (Display.Resolution.getCurrentVerticalPixels(MainActivity.this) == 2192) {
            tempString = "Resolution FHD";
            resolutionTextView.setText(tempString);
        } else if (Display.Resolution.getCurrentVerticalPixels(MainActivity.this) == 2923) {
            tempString = "Resolution WQHD";
            resolutionTextView.setText(tempString);
        }
    }

    protected void refreshTextView()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                tempString = "Refresh Rate " + Tools.Utils.getRefreshRate(MainActivity.this);
                refreshRateTextView.setText(tempString);
            }
        }, 500);

        /////finishAndRemoveTask(); for auto force close
    }
}