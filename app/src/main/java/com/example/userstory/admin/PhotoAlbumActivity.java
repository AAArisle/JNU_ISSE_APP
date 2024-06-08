package com.example.userstory.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.userstory.R;
import com.example.userstory.object.Supervisor;

import java.util.ArrayList;

public class PhotoAlbumActivity extends AppCompatActivity {
    int[] avatars = {R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar, R.drawable.avatar4,
            R.drawable.avatar, R.drawable.avatar6, R.drawable.avatar7, R.drawable.avatar8,
            R.drawable.avatar9, R.drawable.avatar10, R.drawable.avatar11, R.drawable.avatar12,
            R.drawable.avatar13, R.drawable.avatar14, R.drawable.avatar, R.drawable.avatar16,
            R.drawable.avatar17, R.drawable.avatar18, R.drawable.avatar19};
    int avatarPhotoTag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_album);
        Button button = this.findViewById(R.id.photo_button);
        RecyclerView recyclerView = this.findViewById(R.id.recycler_view_photo);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        for(int avatar: avatars){
            avatarsList.add(avatar);
        }
        photoAdapter = new PhotoAlbumActivity.CustomAdapter(this, avatarsList, recyclerView);
        recyclerView.setAdapter(photoAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("imageTag", avatarPhotoTag);
                setResult(Activity.RESULT_OK, intent);
                PhotoAlbumActivity.this.finish();
            }
        });
    }
    PhotoAlbumActivity.CustomAdapter photoAdapter;
    ArrayList<Integer> avatarsList = new ArrayList<>();
    public class CustomAdapter extends RecyclerView.Adapter<PhotoAlbumActivity.CustomAdapter.ViewHolder> {
        private ArrayList<Integer> dataList;
        private Context context;
        private RecyclerView recyclerView;

        public CustomAdapter(Context context, ArrayList<Integer> dataList, RecyclerView recyclerView) {
            this.context = context;
            this.dataList = dataList;
            this.recyclerView = recyclerView;
        }

        @Override
        public PhotoAlbumActivity.CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.supervisor_photo_layout, parent, false);
            return new PhotoAlbumActivity.CustomAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(PhotoAlbumActivity.CustomAdapter.ViewHolder viewHolder, int position) {
            // 设置RecyclerView上视图窗口的信息
            viewHolder.getImageViewAvatar().setImageResource(dataList.get(position));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PhotoAlbumActivity.this);
                    builder.setTitle("选中");
                    builder.setMessage("确定选择这个图片么？");
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for (int i = 0; i < getItemCount(); i++) {
                                // 找到 RecyclerView 中的 ViewHolder
                                PhotoAlbumActivity.CustomAdapter.ViewHolder viewHolderClick =
                                        (ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
                                if (viewHolderClick != null) {
                                    // 修改 ImageView 的背景颜色
                                    viewHolderClick.getImageViewAvatar().setBackgroundColor(getResources().getColor(R.color.white));  // 你想设置的颜色
                                }
                            }
                            viewHolder.getImageViewAvatar().setBackgroundColor(getResources().getColor(R.color.jnu_light));
                            avatarPhotoTag = avatarsList.get(viewHolder.getAdapterPosition());
                        }
                    });
                    builder.create().show();
                }
            });
            // 绑定数据到 ViewHolder 中的视图
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageViewAvatar;

            public ViewHolder(View view) {
                super(view);
                // 初始化视图组件
                imageViewAvatar = view.findViewById(R.id.imageView_avatar_photo);
            }

            public ImageView getImageViewAvatar() {
                return imageViewAvatar;
            }

        }
    }
}