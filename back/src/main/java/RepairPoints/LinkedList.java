package RepairPoints;
public class LinkedList {
    Nodo head;
    Nodo tail;
    int size;
    public LinkedList(){
        head = null;
        size=0;
        tail = null;
    }
    public void push(double lati, double longi){
        Nodo newNodo = new Nodo(lati,longi);
        if(head == null){
            head = newNodo;
            tail = head;
        }else{
            newNodo.setNext(head);
            head.setPrev(newNodo);
            head = newNodo;
        }
        size++;
    }
    public Nodo find(double lati, double longi){
        Nodo current = head;
        while(current != null){
            if(current.getLatitude() == lati && current.getLongitud()==longi){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    public void AddAfter(Nodo node, double lati, double longi){
        Nodo nuevo = new Nodo(lati,longi);
        size++;
        if(node!=null){
            if(node == tail){
                tail.setNext(nuevo);
                nuevo.setPrev(tail);
                tail = nuevo;
            }else{
                node.getNext().setPrev(nuevo);
                nuevo.setNext(node.getNext());
                node.setNext(nuevo);
                nuevo.setPrev(node);
            }
        }
        System.out.println("El nodo ha sido añadido");
    }

    public Nodo pop(double lati, double longi){
        Nodo node = find(lati, longi);
        if(node != null){
            if(node.getPrev() !=null){
                node.getPrev().setNext(node.getNext());
            }else{
                head = node.getNext();
            }

            if(node.getNext()!= null){
                node.getNext().setPrev(node.getPrev());
            }else{
                tail = node.getPrev();
            }
            node.setPrev(null);
            node.setNext(null);
        }
        size--;
        return node;
    }

    public void print(){
        Nodo current= head;
        for(int i =0; i<size;i++){
            double longitud = current.getLongitud();
            double latitud = current.getLatitude();
            System.out.println("El "+ (i+1) + " coordenada del punto de reparacion es: " + latitud + " " + longitud);
            current = current.getNext();
        }

    }
}
