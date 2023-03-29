package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Supplier;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService{
    private final SupplierRepository supplierRepository;
    @Override

    public ResultMessage add(Supplier supplier) {
       if(supplierRepository.existsByPhone_number(supplier.getPhone_number()))
           return new ResultMessage("This supplier already exist",false);
       supplierRepository.save(supplier);
       return new ResultMessage("Supplier successfully added",true);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAllByIs_activeIsTrue();
    }

    @Override
    public Supplier getOne(Integer id) {
        return supplierRepository.findByIs_activeIsTrue(id).orElse(null);
    }

    @Override
    public ResultMessage edit(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findByIs_activeIsTrue(id);
        if(optionalSupplier.isEmpty())
            return new ResultMessage("Supplier not found", false);

        Supplier editingSupplier = optionalSupplier.get();
        editingSupplier.setName(supplier.getName());
        editingSupplier.setPhone_number(supplier.getPhone_number());
        supplierRepository.save(editingSupplier);

        return new ResultMessage("Supplier successfully edited", true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findByIs_activeIsTrue(Id);
        if(optionalSupplier.isEmpty())
            return new ResultMessage("Supplier not found", false);
        Supplier deletingSupplier = optionalSupplier.get();
        deletingSupplier.setIs_active(false);
        supplierRepository.save(deletingSupplier);

        return new ResultMessage("Supplier successfully deleted", true);
    }
}
