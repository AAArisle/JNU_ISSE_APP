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
        populateSupervisorsList();
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
    public ArrayList<Supervisor> allSupervisors = new ArrayList<>();
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
            viewHolder.getImageViewAvatar().setImageResource(dataList.get(position).getImageId());
            viewHolder.getTextViewName().setText(dataList.get(position).getSupervisorName());
            viewHolder.getTextViewDirection().setText(dataList.get(position).getSupervisorDirection());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 在这里处理点击事件，启动详情页面
                    Intent intent = new Intent(context, SupervisorDetailActivity.class);
                    // 传递需要显示的数据，例如可以使用intent.putExtra()方法
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
    public String[] names = {"黄国全","屈挺","郭洪飞","任亚平","闫勉","孙素筠","柳宁","孔锐","杨光华",
            "郭江凌","刘晓翔","施政","赵阔","李晓帆","李军","董铖","张鑫源","李德平","龚雪沅"};
    public String[] directions = {"管理科学与工程","工业物联网、智能制造系统管理、智慧物流与供应链管理","工业工程",
            "优化算法、数学规划、绿色制造与再制造、交通调度优化","人因与工效学、健康信息学、消费者行为学",
            "公共交通网络设计与运输分配、乘车共享与出租车","机器人、数控与工业机器人智能控制技术",
            "机器学习、图像识别","智慧感知、智能通信、人工智能技术及应用", "数字图像处理","图像处理与模式识别",
            "人工智能、智能通信、物联网","区块链，人工智能，大数据，学科交叉融合应用，云计算",
            "智能感知，智能信号与信息处理，脑机接口通信","人工智能技术及应用",
            "数字微流控系统的电子自动化、信号处理和嵌入式系统","人工智能、计算智能、大规模优化",
            "机器人视觉感知与理解","深度学习、神经网络"};
    int[] avatars = {R.drawable.avatar1,R.drawable.avatar2,R.drawable.avatar,R.drawable.avatar4,
            R.drawable.avatar,R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8,
            R.drawable.avatar9, R.drawable.avatar10,R.drawable.avatar11,R.drawable.avatar12,
            R.drawable.avatar13,R.drawable.avatar14,R.drawable.avatar,R.drawable.avatar16,
            R.drawable.avatar17,R.drawable.avatar18,R.drawable.avatar19};

    public void populateSupervisorsList() {
        // 清空列表以确保不会添加重复的导师信息
        allSupervisors.clear();

        // 遍历姓名和研究方向数组，创建Supervisor对象并添加到列表中
        for (int i = 0; i < names.length; i++) {
            allSupervisors.add(new Supervisor(names[i], directions[i], avatars[i]));
        }

    }
}