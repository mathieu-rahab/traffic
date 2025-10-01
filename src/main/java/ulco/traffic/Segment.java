package ulco.traffic;

import java.util.LinkedList;
import java.util.Queue;

public class Segment {
    public Segment(int length, int speed) {
        _length = length;
        _speed = speed;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setSpeed(_speed);
        _vehicles.add(vehicle);
    }

    public Boolean hasVehicule(String id){
        for (Vehicle v : _vehicles) {
            if (v.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void run(Double time) {
    for (Vehicle v : _vehicles) {
        v.setDistance(v.getDistance() + (time * _speed));
    }
    while (!_vehicles.isEmpty() && vehiculeAtEnd(_vehicles.peek().getId()) && _nextSegment != null) {
        Vehicle v = _vehicles.poll();
        v.setDistance(0.0);
        _nextSegment.addVehicle(v);
    }
}

    public boolean vehiculeAtEnd(String id){
        return hasVehicule(id) && getVehicle(id).getDistance() >= _length;
    }

    public int getSpeed(){
        return _speed;
    }

    public void setNextSegment(Segment segment){
        _nextSegment = segment;
    }

    public Vehicle getVehicle(String id){
        for (Vehicle v : _vehicles) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    private int _length;
    private int _speed;
    private Queue<Vehicle> _vehicles = new LinkedList<>();
    private Segment _nextSegment;

}