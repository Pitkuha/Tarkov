package app.profiling;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(log = true, objectName = "Pitkuha.service:name=ShortBean", persistName = "ShortBean")
@Component
@Slf4j
@Data
public class ShortBean implements ShortMBean{
    private final LongBean longBean;

    @Autowired
    public ShortBean(LongBean longBean) {
        this.longBean = longBean;
    }


    @Override
    @ManagedAttribute
    public double getInfo() {
        long allPoint = longBean.getAllPoints();
        long pointInArea = longBean.getAllPointsInArea();
        //double res = (double)(allPoint - pointInArea) / allPoint;
        return (double)(allPoint - pointInArea) / allPoint;
    }
}
