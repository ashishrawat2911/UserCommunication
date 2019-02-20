package com.ashish.usercommunication.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class SimpleDialogFragment extends DialogFragment {
    private final String TAG = "AUC_SIMPLE";
    private SimpleDialogListener mHost;

    public interface SimpleDialogListener {
        public void onPositiveResult(DialogFragment dlg);
        public void onNegativeResult(DialogFragment dlg);
        public void onNeutralResult(DialogFragment dlg);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Peas Preference");
        builder.setMessage("Do you like sugar snap peas?");
        builder.setPositiveButton("Sure!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Positive button clicked");
                mHost.onPositiveResult(SimpleDialogFragment.this);
            }
        });
        builder.setNegativeButton("No way!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Negative button clicked");
                mHost.onNegativeResult(SimpleDialogFragment.this);
            }
        });
        builder.setNeutralButton("Not Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Neutral button clicked");
                mHost.onNeutralResult(SimpleDialogFragment.this);
            }
        });
        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dlg) {
        super.onCancel(dlg);
        Log.i(TAG, "Dialog cancelled");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mHost = (SimpleDialogListener)activity;
    }

}
