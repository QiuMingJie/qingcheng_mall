package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private  BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }


    @RequestMapping("/findPage")
    public PageResult<Brand> findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    @RequestMapping(value = "/findList",method = RequestMethod.POST)
    public List<Brand> findList(@RequestBody Map<String, Object> searchMap) {
        return brandService.findList(searchMap);
    }

    @RequestMapping(value = "/findListPage",method = RequestMethod.POST)
    public PageResult<Brand> findList(int page,int size,@RequestBody Map<String, Object> searchMap) {
        return brandService.findListPage(page,size,searchMap);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Brand findById(Integer id) {
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        return new Result(brandService.add(brand),"");
    }
}
