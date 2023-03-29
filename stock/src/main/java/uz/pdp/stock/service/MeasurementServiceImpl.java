package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Measurement;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService{
    private final MeasurementRepository measurementRepository;


    @Override
    public ResultMessage add(Measurement measurement) {
       if(measurementRepository.existsByName(measurement.getName()))
           return new ResultMessage("This measurment already exist",false);
       measurementRepository.save(measurement);
       return new ResultMessage("Measurment successfully added",true);
    }

    @Override
    public List<Measurement> getAll() {
        return measurementRepository.findAllByIs_activeIsTrue();
    }

    @Override
    public Measurement getOne(Integer id) {
        return measurementRepository.findByIs_activeIsTrue(id).orElse(null);
    }

    @Override
    public ResultMessage edit(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement;
        optionalMeasurement = measurementRepository.findByIs_activeIsTrue(id);
        if(optionalMeasurement.isEmpty())
            return new ResultMessage("Measurement not found", false);
        Measurement editingMeasurement = optionalMeasurement.get();
        editingMeasurement.setName(measurement.getName());
        measurementRepository.save(editingMeasurement);

        return new ResultMessage("Measurement successfully edited", true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findByIs_activeIsTrue(Id);
        if(optionalMeasurement.isEmpty())
            return new ResultMessage("Measurement not found", false);
        Measurement deletingMeasurement = optionalMeasurement.get();
        deletingMeasurement.setIs_active(false);
        measurementRepository.save(deletingMeasurement);

        return new ResultMessage("Measurement successfully deleted", true);
    }
}
