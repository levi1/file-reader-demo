package com.example.file_reader.document;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class DocumentData {

    @Id
    @SequenceGenerator(
            name = "document_data_sequence",
            sequenceName = "document_data_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "document_data_sequence"
    )

    private Long id;
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private String orderPriority;
    private LocalDate orderDate;
    private Long orderId;
    private LocalDate shipDate;
    private String unitsSold;
    private String unitPrice;
    private String unitCost;
    private String totalRevenue;
    private String totalCost;
    private String totalProfit;

    public DocumentData() {
    }

    public DocumentData(String region, String country, String itemType, String salesChannel, String orderPriority, LocalDate orderDate, Long orderId, LocalDate shipDate, String unitsSold, String unitPrice, String unitCost, String totalRevenue, String totalCost, String totalProfit) {
        this.region = region;
        this.country = country;
        this.itemType = itemType;
        this.salesChannel = salesChannel;
        this.orderPriority = orderPriority;
        this.orderDate = orderDate;
        this.orderId = orderId;
        this.shipDate = shipDate;
        this.unitsSold = unitsSold;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.totalRevenue = totalRevenue;
        this.totalCost = totalCost;
        this.totalProfit = totalProfit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public String getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(String unitsSold) {
        this.unitsSold = unitsSold;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(String totalProfit) {
        this.totalProfit = totalProfit;
    }
}
