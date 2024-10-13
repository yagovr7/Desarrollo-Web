package Ejercicio4;

class MiListaEnlazada<G>{
    private Nodo<G> primero=null;
    
    public void insertar(G dato){
        if(primero==null){
            primero=new Nodo<>(dato);
        }else{
            Nodo<G> temp= new Nodo<>(dato,primero);
            primero=temp;
        }
            
    }
    public int tamano(){
        int i=0;
        Nodo<G> temp=primero;
        while(temp!=null){
            i++;
            temp=temp.getSiguiente();
        }
        return i;
    }
    public G obtener(int indice){
        Nodo<G> temp=primero;
        int i=0;
        while(i<indice){
            temp=temp.getSiguiente();
            i++;
        }
            
        return temp.getDato();
    }
}
