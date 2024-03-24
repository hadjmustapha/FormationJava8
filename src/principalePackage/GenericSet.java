package principalePackage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenericSet<T> implements IGenericSet<T>{

    int longueur;
    T monTableau[] ;
    int conteur;

    public GenericSet(int longeur) {
        this.longueur=longeur;
       monTableau = (T[]) new Object[longeur];
    }

    @Override
    public void add(T item) {
      if (contains(item)) return;

      if(conteur<longueur){
          monTableau[conteur] = item;
          conteur++;
      }

    }

    @Override
    public void remove(T item) {
        for (int i =0 ; i<longueur ; i++){
            if(Objects.equals(monTableau[i],item)){
                for (int j =i; j<longueur-1; j++){
                    monTableau[j]=monTableau[j+1];
                }
                monTableau[longueur-1]=null;
                return ;
            }
        }

    }

    @Override
    public T get(int index) {
        return monTableau[index];
    }

    @Override
    public void clear() {
      monTableau = (T[]) new Object[longueur];
    }

    @Override
    public boolean contains(T item) {
        for (var element : monTableau){
            if(Objects.equals(element,item)) return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return conteur;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(monTableau));
    }
}
