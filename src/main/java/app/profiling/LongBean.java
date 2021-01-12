package app.profiling;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import java.util.concurrent.atomic.AtomicInteger;

@ManagedResource(log = true, objectName = "Pitkuha.service:name=LongBean", persistName = "LongBean")
@Component
@Slf4j
@Data
public class LongBean implements LongMBean, NotificationPublisherAware {

    private final AtomicInteger countAllPoints;
    private final AtomicInteger countPointInArea;
    private NotificationPublisher publisher;

    public LongBean(){
        countAllPoints = new AtomicInteger(0);
        countPointInArea = new AtomicInteger(0);
    }

    @Override
    @ManagedAttribute
    public long getAllPoints() {
        return countAllPoints.get();
    }

    @Override
    @ManagedAttribute
    public long getAllPointsInArea() {
        return countPointInArea.get();
    }

    @Override
    @ManagedAttribute
    public boolean crat5() {
        return countAllPoints.get() % 5 == 0;
    }

    @Override
    @ManagedAttribute
    public void loging() {
        if (crat5()){
            this.publisher.sendNotification(new Notification("Info"
                    , this
                    , 0
                    ,"Количество установленных точек стало кратно 5"));
        }
    }

    @Override
    public void incPoints(int value) {
        countAllPoints.getAndAdd(value);
        loging();
    }

    @Override
    public void incPointsInArea(int value) {
        countPointInArea.getAndAdd(value);
    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        this.publisher = notificationPublisher;
    }
}
