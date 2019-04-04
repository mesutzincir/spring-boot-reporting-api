package com.mz.reportingapi.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportParam {
private Date fromDate;
private Date toDate;
private Integer merchant;
private Integer acquirer;
}
