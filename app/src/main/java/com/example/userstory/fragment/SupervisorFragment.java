// 首页【导师】页面
package com.example.userstory.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userstory.R;
import com.example.userstory.activity.SupervisorDetailActivity;
import com.example.userstory.object.Supervisor;

import java.util.ArrayList;

public class SupervisorFragment extends Fragment {



    public SupervisorFragment() {
        // Required empty public constructor
    }
    public static SupervisorFragment newInstance(String param1, String param2) {
        SupervisorFragment fragment = new SupervisorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_supervisor, container, false);
        RecyclerView recyclerView = inflate.findViewById(R.id.recycler_view);
        EditText searchText = inflate.findViewById(R.id.search_edit_text);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
        for (int i = 0; i < 10; i++) {
            allSupervisors.add(new Supervisor("导师姓名" + i, "研究方向" + i, R.drawable.avatar));
        }
        // 个性化导师
        allSupervisors.get(0).setSupervisorName("导师0");
        allSupervisors.get(0).setJob_title("讲师");
        allSupervisors.get(0).setSupervisorDirection("AI");
        allSupervisors.get(0).setIntroduction("我是导师0，一名研究方向为人工智能的讲师。致力于探索AI在各个领域的应用，帮助学生掌握最新的技术和知识。热爱教学，乐于分享，期待与你一起探讨AI的无限可能性。");
        allSupervisors.get(0).setContact_information("10001");

        allSupervisors.get(1).setSupervisorName("导师1");
        allSupervisors.get(1).setJob_title("副院长");
        allSupervisors.get(1).setSupervisorDirection("物联网工程");
        allSupervisors.get(1).setIntroduction("我是导师1，物联网工程副院长。专注于物联网技术的研究和应用，致力于培养学生在智能物联网领域的创新能力和实践能力。热爱教学，乐于分享经验，期待与你一同探索物联网工程的未来发展。");
        allSupervisors.get(1).setContact_information("10002");

        supervisors.addAll(allSupervisors);
        supervisorAdapter = new SupervisorFragment.CustomAdapter(requireActivity(), supervisors);
        recyclerView.setAdapter(supervisorAdapter);

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchContent = searchText.getText().toString();
                supervisors.clear();
                if (!searchContent.equals("")) {
                    supervisorAdapter.notifyDataSetChanged();
                    for (Supervisor supervisor : allSupervisors) {
                        if (supervisor.getSupervisorName().contains(searchContent) || supervisor.getSupervisorDirection().contains(searchContent)) {
                            supervisors.add(supervisor);
                            supervisorAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    supervisors.addAll(allSupervisors);
                    supervisorAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return inflate;
    }
    ArrayList<Supervisor> allSupervisors = new ArrayList<>();
    ArrayList<Supervisor> supervisors = new ArrayList<>();
    SupervisorFragment.CustomAdapter supervisorAdapter;
    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        private ArrayList<Supervisor> dataList;
        private Context context;

        public CustomAdapter(Context context, ArrayList<Supervisor> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        @Override
        public SupervisorFragment.CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.supervisor_item_layout, parent, false);
            return new SupervisorFragment.CustomAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            // 设置RecyclerView上视图窗口的信息
            viewHolder.getImageViewAvatar().setImageResource(dataList.get(position).getImageId());
            viewHolder.getTextViewName().setText(dataList.get(position).getSupervisorName());
            viewHolder.getTextViewDirection().setText(dataList.get(position).getSupervisorDirection());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 在这里处理点击事件，启动详情页面
                    Intent intent = new Intent(context, SupervisorDetailActivity.class);
                    // 传递需要显示的数据，例如可以使用intent.putExtra()方法
                    int currentPosition = viewHolder.getAdapterPosition();
                    intent.putExtra("Supervisor", dataList.get(currentPosition));
                    // 传输intent
                    context.startActivity(intent);
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
            private TextView textViewName;
            private TextView textViewDirection;
            public ViewHolder(View view) {
                super(view);
                // 初始化视图组件
                imageViewAvatar = view.findViewById(R.id.imageView_avatar);
                textViewName = view.findViewById(R.id.textView_name);
                textViewDirection = view.findViewById(R.id.textView_direction);
            }
            public ImageView getImageViewAvatar(){
                return imageViewAvatar;
            }
            public TextView getTextViewName() {
                return textViewName;
            }
            public TextView getTextViewDirection() {
                return textViewDirection;
            }
        }
    }
}