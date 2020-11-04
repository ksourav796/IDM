package com.hyva.idm.icitem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IcItemRepository extends CrudRepository<IcItem,Long> {
   IcItem findByitemCode(String itemCode);
}
