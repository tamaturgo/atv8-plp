using  System;
using  System.Collections.Generic;


namespace obeserver_exemple
{

    #region Interfaces

    public interface IWeatherObserver
    {
        void Update(WeatherInfo weatherInfo);
    }
    
    public interface IWeatherSubject
    {
        void RegisterObserver(IWeatherObserver observer);
        void RemoveObserver(IWeatherObserver observer);
        void NotifyObservers();
    }


    #endregion



    #region Dados

    public class WeatherInfo
    {
        public float Temperature { get; set; }
        public float Humidity { get; set; }
        public float Pressure { get; set; }
    }
    
    public class WeatherStation
    {
        private static readonly WeatherData WeatherData = new WeatherData();
        private readonly WeatherDisplay _weatherDisplay = new WeatherDisplay(WeatherData);

        public void Simulate()
        {
            WeatherData.SetMeasurements(80, 65, 30.4f);
            WeatherData.SetMeasurements(82, 70, 29.2f);
            WeatherData.SetMeasurements(78, 90, 29.2f);
        }
    }



    #endregion
    
    
    #region Impressão

    public class WeatherDisplay : IWeatherObserver
    {
        public WeatherDisplay(WeatherData weatherData)
        {
            weatherData.RegisterObserver(this);
        }

        public void Update(WeatherInfo weatherInfo)
        {
            Console.WriteLine($"WeatherDisplay: {weatherInfo.Temperature} {weatherInfo.Humidity} {weatherInfo.Pressure}");
        }
    }



    #endregion


    
    public class WeatherData : IWeatherSubject
    {
        private readonly List<IWeatherObserver> _observers = new List<IWeatherObserver>();
        private WeatherInfo _weatherInfo;

        public void RegisterObserver(IWeatherObserver observer)
        {
            _observers.Add(observer);
        }

        public void RemoveObserver(IWeatherObserver observer)
        {
            _observers.Remove(observer);
        }

        public void NotifyObservers()
        {
            foreach (var observer in _observers)
            {
                observer.Update(_weatherInfo);
            }
        }

        public void MeasurementsChanged()
        {
            NotifyObservers();
        }

        public void SetMeasurements(float temperature, float humidity, float pressure)
        {
            _weatherInfo = new WeatherInfo {Temperature = temperature, Humidity = humidity, Pressure = pressure};
            MeasurementsChanged();
        }
    }


    
    
    public class Program
    {
        public static void Main(string[] args)
        {
            var weatherStation = new WeatherStation();
            weatherStation.Simulate();
        }
    }
    
    
}