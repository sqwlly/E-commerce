package com.ecommerce.demo.Repository;

import com.ecommerce.demo.model.Good;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodRepository extends CrudRepository<Good, String> {
    @Override
    public void delete(Good good);

    //List<Good> listGoodByPage(int pageIndex, int pageSize);

    Page<Good> findByGoodInfo(String name, PageRequest pageRequest);

    public Good findByGoodId(long goodId);
}
