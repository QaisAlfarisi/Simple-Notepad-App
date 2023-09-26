package com.example.app_notepad2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<String> {

    private ArrayList<String> notesList;
    private LayoutInflater inflater;

    public NoteAdapter(Context context, ArrayList<String> notesList) {
        super(context, 0, notesList);
        this.notesList = notesList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(notesList.get(position));
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}
