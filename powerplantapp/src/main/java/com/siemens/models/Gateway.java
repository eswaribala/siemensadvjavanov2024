package com.siemens.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
public sealed class Gateway extends Device permits Class1Gateway{
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
