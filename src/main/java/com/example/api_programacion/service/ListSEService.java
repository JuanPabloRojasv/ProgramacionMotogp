package com.example.api_programacion.service;

import com.example.api_programacion.model.Kid;
import com.example.api_programacion.model.ListSE;
import com.example.api_programacion.model.dto.FletAgeDTO;
import com.example.api_programacion.model.dto.KidByPositionDTO;
import com.example.api_programacion.model.dto.RangeByAgeDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service

public class ListSEService {
    private ListSE list;

    public ListSEService() {
        list = new ListSE();
        list.addFirst(new Kid("1002654940","Jeronimo Murillo",(byte)19,'M'));
        list.addFirst(new Kid("34344343","Pedro Pérez",(byte)16,'M'));

    }


    public String addFirst(Kid kid)
    {
        list.addFirst(kid);
        return "Kid successfully added";
    }

    public  String addFinal(Kid kid)
    {
        list.addFinal(kid);
        return "Kid successfully added";
    }
    public String invert()
    {
       list.invert();
       return "list invert ready";
    }
    public String deletePosition(int position)
    {
        list.deletePosition(position);
        return  "Kid deleted";
    }
    public String deleteData(String data)
    {
        list.deleteData(data);
        return "Data deleted";
    }
    public String girlsFirst()
    {
        list.girlsFirst();
        return "successfully sorted girls";
    }
    public String addByPosition(KidByPositionDTO kidByPositionDTO)
    {
        list.addByPosition(kidByPositionDTO);
        return "aggregate position";
    }
    public String changeExtreme()
    {
        list.changeExtreme();
        return "swapped succesfully";
    }
    public String mixByGender()
    {
        list.mixByGender();
        return "mix has been executed";
    }

    public String evenAndOdd()
    {
        list.evenAndOdd();
        return"mix has been executed";
    }

    public List<RangeByAgeDTO>RangeByAge()
    {
        List<RangeByAgeDTO> ranges= new ArrayList<>();
        ranges.add(new RangeByAgeDTO(1,4,list.RangeByAge(1,4)));
        ranges.add(new RangeByAgeDTO(5,10, list.RangeByAge(5,9)));
        ranges.add(new RangeByAgeDTO(10,14, list.RangeByAge(10,14)));
        ranges.add(new RangeByAgeDTO(15,18, list.RangeByAge(15,18)));
        return ranges;
    }
    public String deleteletterAndAge(FletAgeDTO fletAgeDTO)
    {
        list.DeleteletterAndAge(fletAgeDTO);
        return "kid eliminated";
    }
}
