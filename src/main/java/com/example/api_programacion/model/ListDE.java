package com.example.api_programacion.model;
import com.example.api_programacion.model.dto.KidByPositionDTO;
import lombok.Data;


@Data
public class ListDE {
    private NodeDE head;
    private int count;
    private int size;

    /// = Contar
    public int count() {
        /// La cabeza está vacía?
        if (head == null) {
            return 0;
        }
        /// Crear temporal que se posicione en la cabeza
        NodeDE temp = head;
        /// Crear contador que inicie en uno
        int counter = 1;
        /// Mientras el temporal esté en su siguiete y que haya datos, sume uno y pásese
        while (temp.getNext() != null) {
            counter += 1;
            temp = temp.getNext();
        }
        /// Retornar contador
        return counter;
    }

    ///  Enlistar
    public Node enlist() {
        /// Se crea una nueva lista
        ListSE list = new ListSE();
        /// Si esta la cabeza es diferente a nulo
        if (this.head != null) {
            /// Crear eltemporal que se posicione en la cabeza
            NodeDE temp = head;
            /// Mientras el temporal esté en su siguiete hayan datos,
            while (temp != null) {
                /// el temporal adiciona los datos a la lista y se pasa
                list.addFirst(temp.getData());
                temp = temp.getNext();
            }
        }
        return list.getHead();
    }

    /// Adicionar al final
    public void add(Kid kid) {
        /// Si la cabeza está vacía haga esto
        if (this.head == null) {
            /// crear un nuevo costal con un niño y ahora ese es cabeza
            NodeDE newNode = new NodeDE(kid);
            head = newNode;
            /// Cabeza sujeta al previo de su siguiente
            head.getNext().setPrevious(head);
        } else {
            /// Si no crear temporal que se pare en la cabeza
            NodeDE temp = head;
            /// Mientras el temporal en su siguiete haya datos, pásese
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            /// Se sale del ciclo, el temporal pasa al ultimo y crea un nuevo costal
            NodeDE newNode = new NodeDE(kid);
            /// temporal toma el nuevo nodo
            temp.setNext(newNode);
            /// El nuevo nodo esta posicionado el temporal
            newNode.setPrevious(temp);
        }
        this.count++;
        /// Se suma 1 al contador
    }

    /// Adicionar al inicio
    public void addToStart(Kid kid) {
        /// Se mete .Data en un nodo
        NodeDE newNode = new NodeDE(kid);
        /// Si la cabeza es diferente de nulo
        if (head != null) {
            /// Nuevo nodo ahora es cabeza, está sujeto al previo de su siguiente
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
        }
        /// Ahora la cabeza es la cabeza es el nuevo nodo y suma 1 al contador
        head = newNode;
        count++;
    }

    /// Invertir
    public void invert() throws Exception {
        /// Si el contador es mayor a uno
        if (this.count > 1) {
            /// Crear una nueva lista
            ListDE new_list = new ListDE();
            /// Crear temporal que se posiciona en la cabeza
            NodeDE temp = this.head;
            /// Mientras haya datos
            while (temp != null) {
                /// Temporal agrega AL INICIO los datos
                new_list.addToStart(temp.getData());
                /// Temporal pásese
                temp = temp.getNext();
            }
            /// cabeza es la cabeza de la nueva lista
            this.head = new_list.head;
        }
    }

    /// Primero las niñas y luego los niños
    public void mixByGender() {
        /// Si hay datos
        if (head != null) {
            /// Si el contador es mayor a 1
            if (count() > 1) {
                /// Se crea una nueva lista
                ListDE newList = new ListDE();
                ///  Se llama a temporal que se posiciona en la cabeza
                NodeDE temp = head;
                ///  Mientras haya datos
                while (temp != null) {
                    ///  Si en los datos del género aparece una "M", de masculino
                    if (temp.getData().getGender() == 'M') {
                        ///  Se adicionan los datos a la nueva lista
                        newList.add(temp.getData());
                        ///  Si no, se adicionan los datos AL INICIO de la nueva lista
                    } else {
                        newList.addToStart(temp.getData());
                    }
                    /// Temporal pásese
                    temp = temp.getNext();
                }
                /// Ahora la cabeza es la cabeza de la nueva lista
                this.head = newList.head;
            }
        }
    }

    /// Borrar por posición
    public void deleteToPosition(int position) {
        /// Entra una posición, si la posición es 1, cabeza toma al siguiente (2) y este se convierte en cabeza, prvio conecta con cabeza
        if (position == 1) {
            head = head.getNext();
            head.getNext().setPrevious(head);
            /// Si no, llamar a temporal que se pare en la cabeza
        } else {
            NodeDE temp = head;
            /// Se crea un contador para saber la posición en la que se encuentra parado el temporal
            int count = 1;
            /// Mientras haya datos: El temporal está en un ciclo para parar uno antes de la posición ingresada
            while (temp != null) {
                if (count == position - 1) {
                    /// El temporal llegó uno antes de la posición
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                    /// Sale del ciclo para evitar Bug
                    break;
                }
                /// El tempral agarra a posición más 1, es decir, el sig del sig
                temp = temp.getNext();
                /// Dado que se eliminó un niño, la lista se hace uno más chica
                size = -1;
            }
        }
    }

    /// Borrar por dato
    public void deleteByData(String data) {
        ///  (En cabeza) Se ingresa a los datos y a la identificación, se compara con la ingresada, si es la misma, cabeza ahora es el sig y prev se conecta a cabeza
        if (head.getData().getIdentification() == data) {
            head = head.getNext();
            head.getNext().setPrevious(head);
        } else {
            /// Si no, se llama a temporal, mientras haya datos:
            NodeDE temp = head;
            while (temp != null) {
                /// Si los datos del siguiente tienen la misma identificación ingresada:
                if (temp.getNext().getData().getIdentification() == data) {
                    /// Temporal, agarre al siguiente de su siguiente, el previo toma a temporal y rompe el ciclo
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                    break;
                }
                /// Pásese
                temp = temp.getNext();
            }
        }
    }

    /// Adicionar por posición
    ///
   // public void addByPosition(int position, Kid kid)
    //{
      //  if (head == null || position == 1)
        //{
          //  addToStart(kid);
        //} else
        //{
          //  if (position > size)
            //{
              //  add(kid);
            //} else
            //{
               // Node temp = head;
                //int count = 1;
                //while (count < (position - 1))
                //{
                    //temp = temp.getNext();
                    //count += 1;
                //}
                //Node newNode = new Node(kid);
                //newNode.setNext(temp.getNext());
                //temp.setNext(newNode);
                //size += 1;
            //}
        //}
    //}
}
