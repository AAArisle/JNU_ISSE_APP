package com.example.userstory.object;

import com.example.userstory.R;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSaverTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() throws IOException {
        DataSaver dataSaver=new DataSaver();
        File tempFile = folder.newFile("professions.json");

        List<Profession> professions = new ArrayList<>();
        professions.add(new Profession("Biology", R.drawable.biology, "Biology is about life.", "Courses cover genetics, etc.", "Requirements include..."));
        professions.add(new Profession("Computer Science", R.drawable.computer_science, "Study of algorithmic processes.", "Courses include programming, etc.", "Requirements include..."));
        professions.add(new Profession("Politics", R.drawable.politics, "Politics involves governance.", "Courses include political theory, etc.", "Requirements include..."));
        dataSaver.save(professions, tempFile.getAbsolutePath());

        // 检查文件是否成功保存
        Assert.assertTrue(tempFile.exists());
    }

    @Test
    public void load() {
    }
}