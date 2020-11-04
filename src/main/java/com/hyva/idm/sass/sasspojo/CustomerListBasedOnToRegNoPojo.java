package com.hyva.idm.sass.sasspojo;

import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sassentities.SassCompany;
import com.hyva.idm.sass.sassentities.SassCustomer;
import com.hyva.idm.sass.sassentities.TransactionsData;

import java.util.List;

public class CustomerListBasedOnToRegNoPojo {
    public List<SassCompany> sassCustomerList;
    public List<CustomerNotifications> customerNotificationsList;
    public List<TransactionsData> transactionsDataList;

    public List<TransactionsData> getTransactionsDataList() {
        return transactionsDataList;
    }

    public void setTransactionsDataList(List<TransactionsData> transactionsDataList) {
        this.transactionsDataList = transactionsDataList;
    }

    public List<CustomerNotifications> getCustomerNotificationsList() {
        return customerNotificationsList;
    }

    public void setCustomerNotificationsList(List<CustomerNotifications> customerNotificationsList) {
        this.customerNotificationsList = customerNotificationsList;
    }

    public List<SassCompany> getSassCustomerList() {
        return sassCustomerList;
    }

    public void setSassCustomerList(List<SassCompany> sassCustomerList) {
        this.sassCustomerList = sassCustomerList;
    }
}
