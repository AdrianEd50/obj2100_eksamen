package com.example.obj2100_eksamen.DTO;

/*import com.example.obj2100_eksamen.DTO.PlassDTO;
import lombok.Data;

import java.util.List;
@Data
public class BillettBestillingDTO {
    private String billettkode;
    private int visningsnr;
    private List<PlassDTO> plasser;

    public String getBillettkode() { return billettkode; }
    public void setBillettkode(String billettkode) { this.billettkode = billettkode; }

    public int getVisningsnr() { return visningsnr; }
    public void setVisningsnr(int visningsnr) { this.visningsnr = visningsnr; }

    public List<PlassDTO> getPlasser() { return plasser; }
    public void setPlasser(List<PlassDTO> plasser) { this.plasser = plasser; }
}
*/

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillettBestillingDTO {
    //private String billettkode;
    private Integer visningsnr;
}