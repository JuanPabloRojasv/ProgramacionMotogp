package com.example.api_programacion.model;


import com.example.api_programacion.model.dto.FletAgeDTO;
import com.example.api_programacion.model.dto.KidByPositionDTO;
import com.example.api_programacion.model.dto.KidBygenderwhitBbrothersDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListSE {
    private Node head;
    private int size;

    public int count() {
        if (head.getData() == null)
        {
            return 0;
        }
        Node temp = head;
        int counter = 1;
        while (temp.getNext() != null) {
            counter += 1;
            temp = temp.getNext();
        }

        return counter;
    }

    public void addFinal(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        }
        size++;
    }

    public void addFirst(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;

            size++;
        }
    }

    public void deletePosition(int position) {
        if (head != null) {
            if (position == 1) {
                head = head.getNext();
            } else {
                Node temp = head;
                int count = 1;
                while (count < (position - 1)) {
                    temp = temp.getNext();
                    count += 1;
                }
                temp.setNext(temp.getNext().getNext());
                size -= 1;
            }
        }
    }

    public void invert() {
        if (head != null) {
            ListSE listCP = new ListSE();
            Node temp = head;
            while (temp != null) {
                listCP.addFirst(temp.getData());
                temp = temp.getNext();
            }
            head = listCP.getHead();
        }


    }

    public void deleteData(String data) {
        if (head.getData().getIdentification() == data) {
            head = head.getNext();
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.getNext().getData().getIdentification() == data) {
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
                temp = temp.getNext();
            }
        }
    }


    public void girlsFirst() {
        if (head != null) {
            Node temp = head;
            ListSE copylist = new ListSE();
            while (temp != null) {
                if (temp.getData().getGender() == 'F') {
                    copylist.addFirst(temp.getData());
                } else {
                    copylist.addFinal(temp.getData());
                }
                temp = temp.getNext();
                head = copylist.getHead();
            }
        }
    }

    public void addByPosition(int position, Kid kid)
    {
        if (head == null || position == 1)
        {
            addFirst(kid);
        } else
        {
            if (position > size)
            {
                addFinal(kid);
            } else
            {
                Node temp = head;
                int count = 1;
                while (count < (position - 1))
                {
                    temp = temp.getNext();
                    count += 1;
                }
                Node newNode = new Node(kid);
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
                size += 1;
            }
        }
    }

    public void changeExtreme() {
        if (head != null) {
            Kid tempkid = head.getData();
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            head.setData(temp.getData());
            temp.setData(tempkid);
        }
    }

    public void mixByGender() {
        if (size > 1) {
            int contM = 1;
            int contF = 2;

            Node temp = head;
            ListSE CPlist = new ListSE();
            while (temp != null) {
                if (temp.getData().getGender() == 'M') {
                    if (contM > CPlist.size) {
                        CPlist.addFinal(temp.getData());
                    } else {
                        CPlist.addByPosition(contM, temp.getData());
                    }
                    contM += 2;
                } else {
                    if (contF > CPlist.size) {
                        CPlist.addFinal(temp.getData());
                    } else {
                        CPlist.addByPosition(contF, temp.getData());
                    }
                    contF += 2;
                }
                temp = temp.getNext();
            }
            head = CPlist.getHead();
        }
    }


    public void evenAndOdd() {
        if (size > 1) {
            if (head != null) {
                Node temp = head;
                ListSE ListCp = new ListSE();
                int contP = 2;
                int contI = 1;
                while (temp != null) {
                    if (temp.getData().getAge() % 2 == 0) {
                        if (contP > ListCp.size) {
                            ListCp.addFinal(temp.getData());
                        } else {
                            ListCp.addByPosition(contP, temp.getData());
                        }
                        contP += 2;
                    } else {
                        if (contI > ListCp.size) {
                            ListCp.addFinal(temp.getData());
                        } else {
                            ListCp.addByPosition(contP, temp.getData());
                        }
                        contI += 2;
                    }
                    temp = temp.getNext();
                }
                head = ListCp.getHead();
            }
        }
    }

    public int RangeByAge(int initial, int end) {

        int count = 0;
        if (head != null) {
            Node temp = head;
            while (temp != null) {
                if (temp.getData().getAge() >= initial && temp.getData().getAge() <= end) {
                    count += 1;
                }
                temp.getNext();
            }
        }
        return count;
    }

    public void DeleteletterAndAge(FletAgeDTO fletAgeDTO) {
        if (head != null) {
            Node temp = head;
            ListSE newlist = new ListSE();
            while (temp != null) {
                // selecciona el primer carater de un string
                if (temp.getData().getName().charAt(0) != fletAgeDTO.getLetter()
                        || temp.getData().getAge() != fletAgeDTO.getAge()) {
                    newlist.addFinal(temp.getData());
                }
                temp = temp.getNext();
            }
            head = newlist.getHead();
        }
    }

    // Metodo que retorna una lista de niños que recibe la edad, el genero dependiendo del numero de hermanos.
    public ListSE addKidByGenderByAgeBywhitbrothers(KidBygenderwhitBbrothersDTO kidBygenderwhitBbrothersDTO) {
        // Creamos una lista copia que reciba los datos pedidos
        ListSE listCP = new ListSE();
        //mientras haya datos haremos esto
        if (head != null)
        {
            // creamos el temporal y que se posicione en cabeza
            Node temp = head;
            // mientras donde este parado el ayudante hayan datos
            while (temp != null)
            {
                // si el genero, edad y el numero de hermanos del niño es el mismo donde esté parado
                if (temp.getData().getGender() == kidBygenderwhitBbrothersDTO.getGender() && temp.getData().getAge() >= kidBygenderwhitBbrothersDTO.getAge() && temp.getData().getNum_brothers() >= 1)
                {
                    // adicione al niño en la lista copia
                    listCP.addFinal(temp.getData());
                }
                // temporal pase
                temp = temp.getNext();

            }
        }
        // retorne la lista copia
        return listCP;
    }

}



