package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author QiuMingJie
 * @date 2019-12-17 23:32
 * @Description
 */
@Service(interfaceName = "com.qingcheng.service.goods.BrandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectAll();
        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);

    }

    @Override
    public PageResult<Brand> findListPage(int page, int size, Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        PageHelper.startPage(page, size);
        Page<Brand> result = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<>(result.getTotal(), result.getResult());
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        System.out.println(brand);
        brand.setLetter("L");
        brandMapper.updateByPrimaryKey(brand);
        Brand brand1 = brandMapper.selectByPrimaryKey(id);
        System.out.println(brand1);
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Brand brand) {
        //selective就是只插入有只的！对于默认值有重要作用
//        brandMapper.insertSelective(brand);
        return brandMapper.insert(brand);
    }

    @Override
    public int update(Brand brand) {
        //不覆盖空值
        return brandMapper.updateByPrimaryKeySelective(brand);
        //覆盖空值
//        brandMapper.updateByPrimaryKey();
    }

    @Override
    public int delete(Integer brandId) {
        return brandMapper.deleteByPrimaryKey(brandId);
    }

    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");
            }
            if (searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))) {
                criteria.andEqualTo("letter", (String) searchMap.get("letter"));
            }
        }
        return example;
    }
}
