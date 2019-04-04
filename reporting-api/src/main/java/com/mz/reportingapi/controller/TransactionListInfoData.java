package com.mz.reportingapi.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionListInfoData {
FxData fx;
CustomerInfo customerInfo;
TransactionListInfoDataT transaction;
AcquirerInfo acquirer;
boolean refundable;
IpnInfo ipn;

}
