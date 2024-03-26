package exam.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportShopDTO {

    @NotNull
    @Size(min = 4)
    @XmlElement
    private String address;

    @NotNull
    @Min(1)
    @Max(50)
    @XmlElement(name = "employee-count")
    private int employeeCount;

    @NotNull
    @Min(20000)
    @XmlElement
    private BigDecimal income;

    @NotNull
    @Size(min = 4)
    @XmlElement
    private String name;

    @NotNull
    @Min(150)
    @XmlElement(name = "shop-area")
    private int shopArea;

    @NotNull
    @XmlElement(name = "town")
    private ShopTownNameDTO town;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ShopTownNameDTO {
        @NotNull
        @XmlElement
        private String name;

        public String getName() {
            return name;
        }
    }

    public String getAddress() {
        return address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public String getName() {
        return name;
    }

    public int getShopArea() {
        return shopArea;
    }

    public ShopTownNameDTO getTown() {
        return town;
    }
}
