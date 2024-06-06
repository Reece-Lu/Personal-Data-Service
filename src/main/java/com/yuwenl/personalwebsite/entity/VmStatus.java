package com.yuwenl.personalwebsite.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class VmStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startupTime;
    private long uptime;
    private double networkTotal;
    private double diskUsed;
    private long memoryUsed;
    private double cpuUsage;
    private double cpuLoadAverage;
    private LocalDateTime timestamp;

    @Transient
    private double memoryUsagePercentage;

    public void setMemoryUsagePercentage(double memoryUsagePercentage) {
        this.memoryUsagePercentage = memoryUsagePercentage;
    }

    public double getMemoryUsagePercentage(double memoryUsagePercentage) {
        return this.memoryUsagePercentage;
    }
}
