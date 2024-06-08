package com.example.userstory.fragment;

import com.example.userstory.R;
import com.example.userstory.object.Supervisor;

import java.util.ArrayList;

// SupervisorDataManager.java
// 这个类似乎不需要，因为之后要做数据持久化，所有数据不再以这种明文的方式储存在代码中，此类的作者可以考虑一下删除这个类
public class SupervisorDataManager {
    private final ArrayList<Supervisor> allSupervisors = new ArrayList<>();

    // 导师数据
    public String[] names = {"黄国全","屈挺","郭洪飞","任亚平","闫勉","孙素筠","柳宁","孔锐","杨光华",
            "郭江凌","刘晓翔","1","赵阔","李晓帆","李军","董铖","张鑫源","李德平","龚雪沅"};
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

    public ArrayList<Supervisor> populateSupervisorsList() {
        // 清空列表以确保不会添加重复的导师信息
        allSupervisors.clear();

        // 遍历姓名和研究方向数组，创建Supervisor对象并添加到列表中
        for (int i = 0; i < names.length; i++) {
            allSupervisors.add(new Supervisor(names[i], directions[i], avatars[i]));
        }
        return allSupervisors;
    }

    // 可以添加其他与导师数据管理相关的方法
}
