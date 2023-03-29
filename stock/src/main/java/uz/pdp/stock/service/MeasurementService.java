package uz.pdp.stock.service;

import uz.pdp.stock.entity.Measurement;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;

public interface MeasurementService {
    ResultMessage add(Measurement measurement);
    List<Measurement> getAll();
   Measurement getOne(Integer id);
    ResultMessage edit(Integer id, Measurement measurement);
    ResultMessage delete(Integer Id);

}
