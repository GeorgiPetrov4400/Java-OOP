package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTest {

    @Test
    public void test_AlarmWithLowPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_AlarmWithHighPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(100.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_AlarmWithNormalPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}