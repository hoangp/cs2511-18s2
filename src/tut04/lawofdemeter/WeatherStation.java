package tut04.lawofdemeter;

public class WeatherStation {
  private Thermometer thermometer;

  public Thermometer getThermometer() {
    return thermometer;
  }
  
  public float getTemperature() {
    return thermometer.getTemperature();
  }
}
