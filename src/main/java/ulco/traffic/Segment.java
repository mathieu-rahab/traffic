package ulco.traffic;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Segment {
    public Segment(int length, int speed, TypeEnd typeEnd) {
        _length = length;
        _speed = speed;
        _typeEnd = typeEnd;
        _lastVehiculeEntryTime = INIT_LAST_VEHICULE_ENTRY_TIME;
        _waitingTimes = new java.util.HashMap<>();
    }

    public Segment(int length, int speed) {
        _length = length;
        _speed = speed;
        _typeEnd = TypeEnd.NONE;
        _lastVehiculeEntryTime = INIT_LAST_VEHICULE_ENTRY_TIME;
        _waitingTimes = new java.util.HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        System.out.println("Ajout du véhicule " + vehicle.getId() + " au segment (" + this.hashCode() + ")");
        vehicle.setSpeed(_speed);
        _vehicles.add(vehicle);
        vehicle.setDistance(0.0);
        _lastVehiculeEntryTime = 0.0;
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
    _lastVehiculeEntryTime += time;
    // Avancer tous les véhicules et actualiser le temps d'attente si besoin
    for (Vehicle v : _vehicles) {
        v.setDistance(v.getDistance() + (time * v.getSpeed()));
        if (vehiculeAtEnd(v.getId())) {
            v.setSpeed(0);
            if (_typeEnd == TypeEnd.STOP_SIGN ) {
                double waitingTime = _waitingTimes.getOrDefault(v.getId(), 0.0) + time;
                _waitingTimes.put(v.getId(), waitingTime);
            }
        }
    }
    // Traiter les véhicules en tête qui peuvent sortir
    while (!_vehicles.isEmpty() && vehiculeAtEnd(_vehicles.peek().getId()) && _nextSegment != null) {
        Vehicle v = _vehicles.peek();
        if (_typeEnd == TypeEnd.STOP_SIGN) {
            double waitingTime = _waitingTimes.getOrDefault(v.getId(), 0.0);
            if (waitingTime >= 5.0 && _nextSegment.getLastVehiculeEntryTime() >= 10) {
                moveVehicleToNextSegment(v.getId());
                _waitingTimes.remove(v.getId());
            } else {
                break; // On ne peut pas sortir, on arrête la boucle
            }
        } else {
            moveVehicleToNextSegment(v.getId());
        }
    }
}
    // méthode appélée lorsque que toutes les condition sont reunies pour faire passer un véhicule au segment suivant
    private void moveVehicleToNextSegment(String id) {
        if (hasVehicule(id) && vehiculeAtEnd(id) && _nextSegment != null) {
            Vehicle v = getVehicle(id);
            _vehicles.remove(v);
            _nextSegment.addVehicle(v);
            if (_waitingTimes.containsKey(v.getId())) {
                _waitingTimes.remove(v.getId());
            }


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

    public double getLastVehiculeEntryTime() {
        return _lastVehiculeEntryTime;
    }

    private int _length;
    private int _speed;
    private Queue<Vehicle> _vehicles = new LinkedList<>();
    private Segment _nextSegment;
    private TypeEnd _typeEnd;
    private double _lastVehiculeEntryTime;
    private Map<String, Double> _waitingTimes;

    public static enum TypeEnd {
        STOP_SIGN,
        NONE
    }
    public static int INIT_LAST_VEHICULE_ENTRY_TIME = 100;

}