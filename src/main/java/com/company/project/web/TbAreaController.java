package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TbArea;
import com.company.project.service.TbAreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/03/05.
*/
@RestController
@RequestMapping("/superadmin")
public class TbAreaController {
    @Resource
    private TbAreaService tbAreaService;

    @PostMapping("/add")
    public Result add(TbArea tbArea) throws ServerException {
        tbAreaService.save(tbArea);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tbAreaService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TbArea tbArea) {
        tbAreaService.update(tbArea);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TbArea tbArea = tbAreaService.findById(id);
        return ResultGenerator.genSuccessResult(tbArea);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TbArea> list = tbAreaService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/areas")
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<TbArea> list = tbAreaService.findAll();
        if(list.size()>0){
        modelMap.put("success",0);
        modelMap.put("areaList",list);
        }else {
            modelMap.put("success",1);
            modelMap.put("areaList",list);
        }
        return modelMap;

    }
    @GetMapping("/areas/{id}")
    private Map<String,Object> getAreaById(@PathVariable("id") Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        TbArea tbArea = tbAreaService.findById(areaId);
        if(tbArea.getAreaId() != null){
        modelMap.put("success",0);
        modelMap.put("area",tbArea);
        }else {
            modelMap.put("success",1);
            modelMap.put("area",tbArea);
        }
        return modelMap;

    }
    @PostMapping("/areas")
    private Map<String,Object> addArea(@RequestBody TbArea tbArea) throws ServerException {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        try {
            modelMap.put("success",tbAreaService.save(tbArea));
        } catch (Exception e) {
            throw new ServerException("无法保存");
        }
        return modelMap;

    }
    @PutMapping("/areas")
    private Map<String,Object> updateArea(@RequestBody TbArea tbArea){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",tbAreaService.update(tbArea));
        return modelMap;

    }
    @DeleteMapping("/areas/{id}")
    private Map<String,Object> deleteArea(@PathVariable("id") Integer areaId){

        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",tbAreaService.deleteById(areaId));
        return modelMap;

    }

}
