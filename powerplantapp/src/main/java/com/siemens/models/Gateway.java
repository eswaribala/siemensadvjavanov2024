package com.siemens.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
public class Gateway extends Device{
    private String dnsName;

    @Override
    public String toString() {
        return "Gateway{" +
                "dnsName='" + dnsName + '\'' +
                ", deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
