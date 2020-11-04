package com.hyva.idm.sass.sassrespositories;

import com.hyva.idm.sass.sassentities.PosPaymentTypes;
import com.hyva.idm.sass.sassentities.SaasState;
import com.hyva.idm.sass.sassentities.SassCompany;
import com.hyva.idm.sass.sassentities.SassOrders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PosPaymentTypesRepository extends CrudRepository<PosPaymentTypes, Long> {
    List<PosPaymentTypes> findBySassOrders(SassOrders orderId);
   PosPaymentTypes findAllBySassOrders(SassOrders orderId);

}
