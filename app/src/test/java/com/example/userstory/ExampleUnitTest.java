package com.example.userstory;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.userstory.fragment.SupervisorDataManager;
import com.example.userstory.object.Supervisor;
import com.example.userstory.fragment.SupervisorFragment;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Mock
    SupervisorFragment supervisorFragment;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // 初始化SupervisorFragment并填充导师列表
        supervisorFragment = new SupervisorFragment();
        supervisorFragment.populateSupervisorsList();
    }

    @Test
    public void testFirstSupervisorInfo() {
        // 获取列表中的第一个导师
        Supervisor firstSupervisor = supervisorFragment.allSupervisors.get(0);

        // 验证第一个导师的信息
        assertEquals("黄国全", firstSupervisor.getSupervisorName());
        assertEquals("管理科学与工程", firstSupervisor.getSupervisorDirection());
        assertEquals(R.drawable.avatar1, firstSupervisor.getImageId());
    }
}