package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoMedicineQroup;
import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.MedicineQroup;
import az.orient.aptek.pojo.OdenishVasiteleri;
import java.util.ArrayList;

public class AptekServiceMedicineQroupImpl implements AptekServiceMedicineQroup {

    private AptekDaoMedicineQroup aptekDaoMedicineQroup;

    public AptekServiceMedicineQroupImpl(AptekDaoMedicineQroup aptekDaoMedicineQroup) {

        this.aptekDaoMedicineQroup = aptekDaoMedicineQroup;
    }

    @Override
    public List<MedicineQroup> getMedicineQroupList() throws Exception {
        return aptekDaoMedicineQroup.getMedicineQroupList();
    }

    @Override
    public boolean addMedicineQroup(MedicineQroup medicineQroup) throws Exception {
        return aptekDaoMedicineQroup.addMedicineQroup(medicineQroup);
    }

    @Override
    public MedicineQroup getMedicineQroupById(Long medicineQroupId) throws Exception {
        return aptekDaoMedicineQroup.getMedicineQroupById(medicineQroupId);
    }

    @Override
    public boolean updateMedicineQroup(MedicineQroup medicineQroup, Long medicineQroupId) throws Exception {
        return aptekDaoMedicineQroup.updateMedicineQroup(medicineQroup, medicineQroupId);
    }

    @Override
    public boolean deleteMedicineQroup(Long medicineQroupId) throws Exception {
        return aptekDaoMedicineQroup.deleteMedicineQroup(medicineQroupId);
    }

    @Override
    public List<MedicineQroup> searchMedicineQroupData(String keyword) throws Exception {
        return aptekDaoMedicineQroup.searchMedicineQroupData(keyword);
    }

    @Override
    public boolean checkMedicineQroup(MedicineQroup medicineQroup,boolean result) throws Exception {
       if (result) {
            List<MedicineQroup> medicineQroupsList = new ArrayList<>();
            medicineQroupsList = aptekDaoMedicineQroup.getMedicineQroupList();
            MedicineQroup editedMedicineQroup = medicineQroup;
            medicineQroupsList.remove(medicineQroup);

            for (MedicineQroup medicineQroup1 : medicineQroupsList) {
                if (medicineQroup1.getId().equals(editedMedicineQroup.getId())) {
                    continue;
                }
                if ((medicineQroup1.getQroupName().equals(editedMedicineQroup.getQroupName()))) {
                    return true;
                }
            }
            return false;
        } else {
            return aptekDaoMedicineQroup.checkMedicineQroup(medicineQroup, result);
        }
        }


}
