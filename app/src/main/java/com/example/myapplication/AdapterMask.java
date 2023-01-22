package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMask  extends BaseAdapter {
    private Context mContext;
    List<Mask> maskList;

    public AdapterMask(Context mContext, List<Mask> maskList)
    {
        this.mContext = mContext;
        this.maskList = maskList;
    }
    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int position) {
        return maskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return maskList.get(position).getID();
    }

    private Bitmap getUserImage(String encodedImg)
    {

        if(encodedImg!=null&& !encodedImg.equals("null")) {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
        {
            return  BitmapFactory.decodeResource(mContext.getResources(),R.drawable.ic_launcher_playstore);

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            View v= View.inflate(mContext,R.layout.activity_adapter_mask, null);
            Mask mask= maskList.get(position);

            TextView power = v.findViewById(R.id.Power_mask);
            TextView name = v.findViewById(R.id.Name_mask);
            ImageView imageView = v.findViewById(R.id.Image_mask);

            power.setText((mask.getPower()));
            name.setText(mask.getName());
            imageView.setImageBitmap(getUserImage(mask.getImage()));

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext,Update_Delete.class);
                    intent.putExtra("Autoes",mask);
                    mContext.startActivity(intent);

                }
            });
            return v;
    }
}
