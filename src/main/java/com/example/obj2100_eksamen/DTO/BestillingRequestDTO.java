package com.example.obj2100_eksamen.DTO;

import java.util.List;

public class BestillingRequestDTO {
    private BillettBestillingDTO billett;
    private List<PlassDTO> plasser;

    public BillettBestillingDTO getBillett() {
        return billett;
    }

    public void setBillett(BillettBestillingDTO billett) {
        this.billett = billett;
    }

    public List<PlassDTO> getPlasser() {
        return plasser;
    }

    public void setPlasser(List<PlassDTO> plasser) {
        this.plasser = plasser;
    }
}