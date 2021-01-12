package app.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DotDTO {
    @NotNull(message = "X is required")
    @Min(value = -5, message = "X must be greater than -5")
    @Max(value = 5, message = "X must be greater than 5")
    private Double x;

    @NotNull(message = "Y is required")
    @Min(value = -5, message = "Y must be greater than -5")
    @Max(value = 3, message = "Y must be greater than 5")
    private Double y;

    @NotNull(message = "R is required")
    @Min(value = 0, message = "R must be greater than 0")
    @Max(value = 5, message = "R must be greater than 5")
    private Double r;

    private Boolean result;

    DotDTO(){}

    DotDTO(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public DotDTO(Dot d) {
        this.x = d.getX();
        this.y = d.getY();
        this.r = d.getR();
        this.result = d.isResult();
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
