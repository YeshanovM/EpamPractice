public class TemperatureConverter {

    public static double convertFtoC(double degreesFahrenheit) {
        return (degreesFahrenheit - 32.0) / 9.0 * 5.0;
    }

    public static double convertCtoF(double degreesCelsius) {
        return degreesCelsius / 5.0 * 9.0 + 32.0;
    }

    public static double convertCtoK(double degreesCelsius) {
        return degreesCelsius + 273.2;
    }

    public static double convertKtoC(double kelvin) {
        return kelvin - 273.2;
    }

    public static double convertFtoK(double degreesFahrenheit) {
        return (degreesFahrenheit + 459.7) / 9.0 * 5.0;
    }

    public static double convertKtoF(double kelvin) {
        return kelvin / 5.0 * 9.0 - 459.7;
    }
}