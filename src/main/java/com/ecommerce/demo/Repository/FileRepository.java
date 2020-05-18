package com.ecommerce.demo.Repository;

import com.ecommerce.demo.model.UpLoadFile;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<UpLoadFile, String > {

    @Override
    void delete(UpLoadFile upLoadFile);

}
