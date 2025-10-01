package ulco.traffic;

public class Vehicle {
    public Vehicle(){
        _id = "v" + String.valueOf(Vehicle._idClass);
        Vehicle._idClass += 1;
        System.out.println("Vehicle ID: " + _id);
        _distance = 0.0;
    }


    public void setSpeed(int speed){
        _speed = speed;
        
    }

    public int getSpeed(){
        return _speed;
    }

    public String getId(){
        return _id;
    }
    
    public void setDistance(Double distance){
        _distance = distance;
    }


    public Double getDistance(){
        return _distance;
    }

    public double getSize(){
        return _size;
    }



    private Double _distance;
    private int _speed;
    private String _id;
    private static int _idClass = 1;
    private double _size = SIZE_VEHICLE;

    private static final double SIZE_VEHICLE = 4.5;


}
