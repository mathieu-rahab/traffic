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



    private Double _distance;
    private int _speed;
    private String _id;
    private static int _idClass = 1;


}
