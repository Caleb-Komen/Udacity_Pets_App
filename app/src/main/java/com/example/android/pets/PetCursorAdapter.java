package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetContract.PetEntry;

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView summary = (TextView) view.findViewById(R.id.summary);

        String petName = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME));
        String petSummary = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED));

        if (TextUtils.isEmpty(petSummary)){
            petSummary = context.getString(R.string.unknown_breed);
        }

        name.setText(petName);
        summary.setText(petSummary);


    }
}
