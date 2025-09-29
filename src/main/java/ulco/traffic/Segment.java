package ulco.traffic;

public class Segment {
    public Segment(int length, int speed) {
        _length = length;
        _speed = speed;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setSpeed(_speed);
        _vehicle = vehicle;
    }

    public Boolean hasVehicule(String id){
        return _vehicle != null &&  _vehicle.getId() == id;
    }

    public void run(Double time) {
        _vehicle.setDistance(_vehicle.getDistance() + (time * _speed));
        if (vehiculeAtEnd(_vehicle.getId()) && _nextSegment != null) {
            _vehicle.setDistance(0.0);
            _nextSegment.addVehicle(_vehicle);
            _vehicle = null;
        }

    }

    public boolean vehiculeAtEnd(String id){
        return hasVehicule(id) && _vehicle.getDistance() >= _length;
    }

    public int getSpeed(){
        return _speed;
    }

    public void setNextSegment(Segment segment){
        _nextSegment = segment;
    }


    private int _length;
    private int _speed;
    private Vehicle _vehicle;
    private Segment _nextSegment;

}