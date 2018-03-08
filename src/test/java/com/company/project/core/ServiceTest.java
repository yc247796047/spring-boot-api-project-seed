package com.company.project.core;

import com.company.project.model.TbArea;
import com.company.project.model.Websites;
import com.company.project.service.TbAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.TabableView;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yangchun on 2018/3/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private TbAreaService tbAreaService;

    @Test
    public void findAreas() {
        List<TbArea> tbAreas = tbAreaService.findAll();
        assertEquals(2,tbAreas.size());
    }

    @Test
    public void findAreaById() {
        TbArea tbAreas = tbAreaService.findById(1);
        assertEquals("东1苑",tbAreas.getAreaName());
    }

    @Test
    public void insertArea() {
        TbArea tbArea =new TbArea();
        tbArea.setAreaName("南苑3");
        tbArea.setPriority(2);
        int result = tbAreaService.save(tbArea);
        assertEquals(0,result);
    }
    @Test
    public void updateArea() {
        TbArea tbArea =new TbArea();
        tbArea.setAreaId(7);
        tbArea.setAreaName("南苑331");
        tbArea.setPriority(3);
        int result = tbAreaService.update(tbArea);
        assertEquals(0,result);

    }
}
