package com.hyva.idm.sass.sassrespositories;
import com.hyva.idm.sass.sassentities.PositionTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionTableRepository extends JpaRepository<PositionTable,Long> {
    List<PositionTable> findAllByApplicationIdAndMasterName(String appId,String masterName);
    List<PositionTable> findByApplicationIdAndMasterName(String appId,String masterName);
}
