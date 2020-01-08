package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author QiuMingJie
 * @date 2019-12-17 23:31
 * @Description
 */
public interface BrandService {
    public List<Brand> findAll();

    public PageResult<Brand> findPage(int page, int size);

    public List<Brand> findList(Map<String ,Object> searchMap);

    public PageResult<Brand> findListPage(int page, int size, Map<String, Object> searchMap);

    public Brand findById(Integer id);

    public int add(Brand brand);

    public int update(Brand brand);

    public int delete(Integer brandId);
}
