package exam.model.dto;

import exam.model.entity.WarrantyType;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ImportLaptopDTO {

    @NotNull
    @Size(min = 8)
    private String macAddress;

    @NotNull
    @Positive
    private double cpuSpeed;

    @NotNull
    @Min(8)
    @Max(128)
    private int ram;

    @NotNull
    @Min(128)
    @Max(1024)
    private int storage;

    @NotNull
    @Size(min = 10)
    private String description;

    @Positive
    private BigDecimal price;

    @NotNull
    private WarrantyType warrantyType;

    @NotNull
    private LaptopShopNameDTO shop;

    public static class LaptopShopNameDTO {

        private String name;

        public String getName() {
            return name;
        }
    }

    public String getMacAddress() {
        return macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public LaptopShopNameDTO getShop() {
        return shop;
    }
}
