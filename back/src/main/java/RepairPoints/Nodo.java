package RepairPoints;

public class Nodo {
    double latitud;
    double longitud;
    Nodo next;
    Nodo prev;

    public Nodo(double latitud, double longitud){
        this.latitud= latitud;
        this.longitud = longitud;
        this.next = null;
        this.prev = null;

    }
    public void setNext(Nodo next) {
        this.next = next;
    }
    public void setPrev(Nodo prev) {
        this.prev =prev;
    }
    public String getNodo() {
        return latitud  + " " + longitud;
    }
    public Nodo getNext() {
        return next;
    }
    public Nodo getPrev() {
        return prev;
    }
    public double getLatitude() {
        return latitud;
    }
    public double getLongitud() {
        return longitud;
    }
}
