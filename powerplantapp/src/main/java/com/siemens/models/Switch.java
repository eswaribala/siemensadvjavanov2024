package com.siemens.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Switch {
    private long switchId;
    private SwitchType switchType;
    private int ranges;
    private List<Router> routers;
}
