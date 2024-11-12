package com.siemens.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public non-sealed  class Gateway extends Device  {
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
