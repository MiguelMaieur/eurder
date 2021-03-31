package com.example.api.dto.order;

import java.util.ArrayList;
import java.util.List;

public class HistoryReportDTO {

    private final List<HistoryReport> historyReport;
    private Double totalOrdersPrice = 0.0;

    public HistoryReportDTO() {
        historyReport = new ArrayList<>();
    }

    public List<HistoryReport> getHistoryReport() {
        return historyReport;
    }

    public Double getTotalOrdersPrice() {
        return totalOrdersPrice;
    }

    public HistoryReportDTO addHistory(HistoryReport historyReport) {
        this.historyReport.add(historyReport);
        return this;
    }

    public void setTotalOrdersPrice(Double totalOrdersPrice) {
        this.totalOrdersPrice += totalOrdersPrice;
    }
}
