package com.delose.java.lts.design_patterns.behavior;

import java.util.ArrayList;
import java.util.List;

interface WeatherObserver {
    void update(int temperature);
}

class WeatherStation {
    private final List<WeatherObserver> weatherObservers = new ArrayList<>();
    private int temperature;

    public void addObserver(WeatherObserver weatherObserver) {
        weatherObservers.add(weatherObserver);
    }

    public void removeObserver(WeatherObserver weatherObserver) {
        weatherObservers.remove(weatherObserver);
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver weatherObserver: weatherObservers) {
            weatherObserver.update(temperature);
        }
    }
}

class PhoneDisplay implements WeatherObserver {

    @Override
    public void update(int temperature) {
        System.out.println("Phone display: Temperature updated to " + temperature + "C.");
    }
}

class WebDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Web display: Temperature updated to " + temperature + "C.");
    }
}

public class Observer {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObserver(new PhoneDisplay());
        weatherStation.addObserver(new WebDisplay());

        weatherStation.setTemperature(30);
        weatherStation.setTemperature(25);
    }
}
