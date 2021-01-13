package app.DTO;

import app.domain.Magazin;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MagazinsDTO {
    @NotNull
    @Min(value = 1)
    private double ergonomics;
    @NotNull
    @Min(value = 0)
    private double caliber;

    public MagazinsDTO(Magazin magazin) {
        this.ergonomics = magazin.getErgonomics();
        this.caliber = magazin.getCaliber();
    }

    public MagazinsDTO() {
    }

    public double getErgonomics() {
        return ergonomics;
    }

    public void setErgonomics(double ergonomics) {
        this.ergonomics = ergonomics;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }
}
