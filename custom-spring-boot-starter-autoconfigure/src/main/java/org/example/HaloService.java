package org.example;

import org.springframework.beans.factory.annotation.Autowired;

public class HaloService {
    @Autowired
    private HaloProperties haloProperties;

    public void hi() {
        System.out.println(haloProperties.getPrefix());
        System.out.println(haloProperties.getSuffix());
    }
}
