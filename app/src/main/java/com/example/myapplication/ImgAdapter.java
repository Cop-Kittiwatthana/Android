package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.Holder> {

    private List<String> imgitem;
    private Context mContext;

    public ImgAdapter(Context context,List<String> data){
        imgitem = data;
        mContext = context;
        Log.e("SIZE", "getItemCount: " + data.size());
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holders, int position) {
        holders.setiItem(position);
    }

    @Override
    public int getItemCount() {

        return imgitem.size();
    }


    class Holder extends RecyclerView.ViewHolder{

        ImageView img;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
        void setiItem(final int position){
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
            StorageReference storageReference = firebaseStorage.getReferenceFromUrl("gs://appdatabase-2c46c.appspot.com");
            StorageReference file = storageReference.child("img/"+imgitem.get(position));
            file.getDownloadUrl()
                    .addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Glide.with(mContext)
                                    .load(uri)
                                    .centerCrop()
                                    .into(img);
                        }
                    });
        }
    }
}

