package tut04.lawofdemeter;

public class House { 
  WeatherStation station;

  public float getTempReading() {
    Thermometer thermometer = station.getThermometer();
    return thermometer.getTemperature();
  }
}
